"""
Organizes LeetCode solution folders (as pushed by LeetSync) into a
nested structure by PRIMARY TOPIC, then DIFFICULTY:

    <PrimaryTopic>/<Difficulty>/<number>-<slug>/
        README.md
        <slug>.<ext>

"Primary topic" = the first topic tag LeetCode lists for the problem
(usually its most defining category, e.g. "Array", "Tree", "Graph").
A problem is only ever moved into ONE topic folder — no duplicated
files — even though LeetCode may tag it with several topics.

Difficulty is read directly from the problem's own README.md (LeetSync
writes a difficulty badge there), so that part needs no network call.
Topic requires one API call per NEW problem (cached after the first
run, so re-runs are fast and don't re-query solved problems).

USAGE:
    Place this script in the folder that contains your LeetSync
    problem folders (likely "main/"), then run:

        python organize_leetcode.py

Safe to re-run: already-sorted folders are detected and skipped, and
it will also pick up any folders left over from a previous flat
Easy/Medium/Hard-only sort.
"""

import json
import os
import re
import shutil
import urllib.request

TOPIC_CACHE_FILE = ".topic_cache.json"
FOLDER_PATTERN = re.compile(r"^\d+-[a-z0-9-]+$", re.IGNORECASE)
KNOWN_DIFFICULTIES = {"Easy", "Medium", "Hard"}

GRAPHQL_URL = "https://leetcode.com/graphql"
GRAPHQL_QUERY = """
query questionInfo($titleSlug: String!) {
  question(titleSlug: $titleSlug) {
    difficulty
    topicTags { name }
  }
}
"""


def load_cache():
    if os.path.exists(TOPIC_CACHE_FILE):
        with open(TOPIC_CACHE_FILE, "r") as f:
            return json.load(f)
    return {}


def save_cache(cache):
    with open(TOPIC_CACHE_FILE, "w") as f:
        json.dump(cache, f, indent=2)


def extract_slug_and_difficulty(readme_path):
    with open(readme_path, "r", encoding="utf-8", errors="ignore") as f:
        content = f.read()
    slug_match = re.search(r"leetcode\.com/problems/([a-z0-9-]+)", content, re.IGNORECASE)
    diff_match = re.search(r"Difficulty-(\w+)-", content)
    slug = slug_match.group(1) if slug_match else None
    difficulty = diff_match.group(1) if diff_match else None
    return slug, difficulty


def fetch_primary_topic(slug, cache):
    """Returns the first topic tag for a problem, e.g. 'Array'. Cached."""
    if slug in cache:
        return cache[slug]

    payload = json.dumps({
        "query": GRAPHQL_QUERY,
        "variables": {"titleSlug": slug},
    }).encode("utf-8")

    req = urllib.request.Request(
        GRAPHQL_URL,
        data=payload,
        headers={
            "Content-Type": "application/json",
            "Referer": f"https://leetcode.com/problems/{slug}/",
            "User-Agent": "Mozilla/5.0",
        },
    )

    topic = "Uncategorized"
    try:
        with urllib.request.urlopen(req, timeout=10) as response:
            data = json.load(response)
        tags = data["data"]["question"]["topicTags"]
        if tags:
            topic = tags[0]["name"]
    except Exception as e:
        print(f"  (couldn't fetch topic for {slug}: {e}) -> filing as Uncategorized")

    cache[slug] = topic
    return topic


def find_problem_folders(root="."):
    """
    Finds every LeetCode problem folder under root, including ones left
    over from a previous Easy/Medium/Hard-only sort. Skips .git and
    won't descend into a folder once it's identified as a problem folder.
    """
    matches = []
    for dirpath, dirnames, filenames in os.walk(root):
        if ".git" in dirpath.split(os.sep):
            dirnames[:] = []
            continue

        keep = []
        for d in dirnames:
            if FOLDER_PATTERN.match(d) and os.path.exists(os.path.join(dirpath, d, "README.md")):
                matches.append(os.path.join(dirpath, d))
                # don't descend into a matched problem folder
            else:
                keep.append(d)
        dirnames[:] = keep
    return matches


def main():
    cache = load_cache()
    moved, skipped, unparsed = 0, 0, 0

    problem_folders = find_problem_folders(".")

    for folder_path in problem_folders:
        readme_path = os.path.join(folder_path, "README.md")
        slug, difficulty = extract_slug_and_difficulty(readme_path)
        folder_name = os.path.basename(folder_path)

        if not slug or not difficulty:
            print(f"  Skipping {folder_path}: couldn't parse slug/difficulty")
            unparsed += 1
            continue

        topic = fetch_primary_topic(slug, cache)
        dest_dir = os.path.join(topic, difficulty, folder_name)

        if os.path.abspath(dest_dir) == os.path.abspath(folder_path) or os.path.exists(dest_dir):
            skipped += 1
            continue

        os.makedirs(os.path.join(topic, difficulty), exist_ok=True)
        shutil.move(folder_path, dest_dir)
        print(f"  {folder_name}  ->  {topic}/{difficulty}/")
        moved += 1

    save_cache(cache)
    print(f"\nDone. Moved: {moved}, Already sorted: {skipped}, Unparsed: {unparsed}")


if __name__ == "__main__":
    main()

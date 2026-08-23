# LeetCode Solutions

Personal archive of my [LeetCode](https://leetcode.com/) submissions, automatically synced from LeetCode and organized by topic and difficulty. Maintained alongside my coursework and DSA practice at IIIT Nagpur.

## 🔌 Extensions Used

- **[LeetSync](https://github.com/nishanbajracharya/LeetSync)** — a browser extension that automatically pushes each accepted LeetCode submission straight to this repository. Every solve creates a `<number>-<problem-slug>/` folder containing the solution file and a `README.md` with the problem statement, difficulty, and link.

## 📁 Repository Structure

Solutions are organized by **primary topic**, then **difficulty**:

```
main/
├── Array/
│   ├── Easy/
│   │   └── 1-two-sum/
│   │       ├── README.md
│   │       └── two-sum.java
│   └── Medium/
├── Tree/
│   └── Medium/
│       └── 2493-reverse-odd-levels-of-binary-tree/
├── Uncategorized/
│   └── (problems whose topic couldn't be auto-fetched)
├── organize_leetcode.py
└── README.md
```

"Primary topic" is the first tag LeetCode lists for a problem (its most defining category). A problem is only ever filed once — no duplicated files — even if LeetCode tags it with multiple topics.

## 🛠 How Solutions Are Organized

Sorting is handled by [`organize_leetcode.py`](./organize_leetcode.py), which:

1. Reads each problem's own `README.md` (written by LeetSync) to get its **difficulty** — no network call needed
2. Queries the [LeetCode GraphQL API](https://leetcode.com/graphql) for the problem's **topic tags**, using the first tag as the primary topic
3. Moves the problem folder into `<Topic>/<Difficulty>/`

Runs are cached (`.topic_cache.json`), so re-running only processes newly solved problems.

### Usage

```bash
git pull                     # LeetSync pushes directly to GitHub, so pull first
python organize_leetcode.py  # sort any newly synced problems
git add . ; git commit -m "Organize solutions" ; git push
```

## 💻 Tech / Tools

- **Languages:** Java (primary)
- **Sync:** LeetSync browser extension
- **Automation:** Python (topic + difficulty classification via LeetCode API)

## 📈 Purpose

This repo serves as:
- An automatically growing, well-organized record of every problem solved
- A way to review solutions by topic (e.g. all Graph or DP problems) or by difficulty
- A reference to revisit past approaches before attempting harder problems

## 🔗 Links

- [LeetCode Profile](https://leetcode.com/) (https://leetcode.com/u/Ashwini_Kansal/)

---

*Maintained by Ashwini · IIIT Nagpur*

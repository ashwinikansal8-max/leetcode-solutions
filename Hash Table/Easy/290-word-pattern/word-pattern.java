class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] words = s.split(" ");

                if(pattern.length()!=words.length) return false;

        
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String w = words[i];

            if(hm.containsKey(c)){
                if(!w.equals(hm.get(c))) return false;
            }
            else{
                if(!set.contains(w)){
                  set.add(w);
                  hm.put(c,w);
                }
                else return false;
            }
        }
        return true;
    }
}
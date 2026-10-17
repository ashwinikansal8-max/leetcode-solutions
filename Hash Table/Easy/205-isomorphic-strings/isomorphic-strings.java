class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(hm.containsKey(c)){
                char c2 = t.charAt(i);
                if(hm.get(c)!=c2) return false;
            }
            else{
                if(!set.contains(t.charAt(i))){
                hm.put(c,t.charAt(i));
                set.add(t.charAt(i));
                }
                else return false;
            }
        }
         return true;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2=t.length();
        if(n1!=n2) return false;
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<n1;i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else{
                hm.put(c,1);
            }
        }

        for(int i=0;i<n2;i++)
        {
            char c = t.charAt(i);
            if(!hm.containsKey(c) || hm.get(c)<=0){
                   return false;
            }
            else{
                 hm.put(c,hm.get(c)-1);
            }
        }
        return true;
    }
}
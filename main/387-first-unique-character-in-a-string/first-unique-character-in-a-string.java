class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        if(n==1) return 0;

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }
            else hm.put(c,1);
        }

        for(int i=0;i<n;i++){
             char c= s.charAt(i);
            if(hm.get(c)==1)
            {
                return i;
            }
        }

        return -1;
    }
}
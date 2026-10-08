class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0 || n==1) return n;

        HashMap<Character,Integer> hm = new HashMap<>();
        int ans=0,left=0;
        for(int right=0;right<n;right++)
        {   
            char c = s.charAt(right);
            if(hm.containsKey(c))
            {
               left = Math.max(left,hm.get(c)+1);
            }
            ans = Math.max(ans,right-left+1);
            hm.put(c,right);
        }
        return ans;
    }
}
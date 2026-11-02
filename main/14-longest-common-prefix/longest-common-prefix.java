class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int idx=0;
        while(idx<first.length() && idx<last.length()){
               if(first.charAt(idx)==last.charAt(idx)) ans=ans+first.charAt(idx);
               else break;
               idx++;
        }
        return ans;
    }
}
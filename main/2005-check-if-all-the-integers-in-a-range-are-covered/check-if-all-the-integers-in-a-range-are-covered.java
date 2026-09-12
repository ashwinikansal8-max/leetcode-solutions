class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for(int[] t: ranges)
        {
            diff[t[0]]+=1;
            diff[t[1]+1]-=1;
        }
        int curr=0;
        for(int i=1;i<51;i++)
        {
           curr+=diff[i];
           if((i>=left && i<=right) && curr==0){
             return false;
           }
           if(i>right) break;
        }
        return true;
    }
}
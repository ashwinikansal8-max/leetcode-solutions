class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min=0,max=0,ans=0;
        for(int i: nums)
        {
            min = Math.min(0,min+i);
            max = Math.max(0,max+i);

            ans = Math.max(ans,Math.max(-min,max));
        }
        return ans;
    }
}
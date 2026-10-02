class Solution {
    public int removeDuplicates(int[] nums) {
        int w=0,n=nums.length,ans=0;
        for(int r=0;r<n;r++)
        {
            if(r==0 || nums[r]!=nums[r-1]) nums[w++]=nums[r];
        }
        return w;
    }
}
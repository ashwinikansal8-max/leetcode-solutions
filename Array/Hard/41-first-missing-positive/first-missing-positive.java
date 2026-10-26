class Solution {
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n==1 && nums[0]!=1) return 1;
        if(n==1 && nums[0]==1) return 2;
         for(int i=0;i<n;i++){
            while(nums[i]>=1 && nums[i]<=n && (nums[i]!=nums[nums[i]-1]))
            {
                int t=nums[i];
                nums[i]=nums[t-1];
                nums[t-1]=t;
            }
         }

         for(int i=0;i<n;i++){
            if(nums[i]!=(i+1)) return (i+1);
         }

         return n+1;
    }
}
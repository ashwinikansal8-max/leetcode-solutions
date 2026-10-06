class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curr=0,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            curr+=nums[i];
            max = Math.max(max,curr);
            if(curr<0) curr=0;
        }
          
          int min=Integer.MAX_VALUE;
          curr=0;
          for(int i=0;i<nums.length;i++)
          {
             curr+=nums[i];
             min = Math.min(min,curr);
             if(curr>0) curr=0;
          }

          return Math.max(max,Math.abs(min));
    }
}
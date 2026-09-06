class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int s=0,m=0,n = nums.length;

        for(int i=0;i<k;i++){
           s+=nums[i];
        }
        

        for(int i=0;i<=n-k;i++)
        {
          if((double)s/k >= threshold) m++;
            
            s = s- nums[i] + nums[(i+k)%n];
        }

        return m;
    }
}
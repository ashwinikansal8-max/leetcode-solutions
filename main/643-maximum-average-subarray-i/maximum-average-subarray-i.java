class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
       int s=0,m=0,n = nums.length;

        for(int i=0;i<k;i++){
           s+=nums[i];
        }
        m=s;

        for(int i=0;i<=n-k;i++)
        {
            if(s>m) m = s;
            
            s = s- nums[i] + nums[(i+k)%n];
        }

        return (double)m/k;
    }
}
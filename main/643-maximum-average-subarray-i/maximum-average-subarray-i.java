class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double curravg=0.0,maxavg=0.0;
        int n = nums.length;

        for(int i=0;i<k;i++){
            maxavg+=(double)nums[i]/k;
        }
        curravg = maxavg;

        for(int i=0;i+k<=n;i++)
        {
            if(curravg>maxavg) maxavg = curravg;
            
            curravg = (curravg - (double)nums[i]/k + (double)nums[(i+k)%n]/k);
        }

        return maxavg;
    }
}
class Solution {
    public int countGoodRotations(int[] nums) {
        int n= nums.length,k=n/2;
        int fh=0,sh=0,ts=0,c=0;
        for(int i=0;i<k;i++) fh+=nums[i];

        for(int i=0;i<n;i++) ts+=nums[i];

        for(int i=0;i<n;i++){
            sh = ts-fh;
            if(fh>sh) c++;

                fh = fh - nums[i] + nums[(i+k)%n];
        }

                return c;
    }
}
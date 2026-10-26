class Solution {
    public int sortPermutation(int[] nums) {
        int k=-1;
        boolean issorted = true;

        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                issorted = false;
                k &= nums[i];
            }
        }

        if(issorted) return 0;

        return k;
    }
}
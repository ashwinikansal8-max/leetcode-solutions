class Solution {
    public int thirdMax(int[] nums) {
        long fm,sm,tm;
         fm=sm=tm=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if (nums[i] == fm || nums[i] == sm || nums[i] == tm) {
                continue;
            }
            if(nums[i]>fm){
                tm=sm;
                sm=fm;
                fm=nums[i];
            }
            else if(nums[i]>sm){
                tm=sm;
                sm=nums[i];
            }
            else if(nums[i]>tm){
                tm=nums[i];
            }
        }
        if(tm==Long.MIN_VALUE ) return (int)fm;

        return (int)tm;
    }
}
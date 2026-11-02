class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int med=nums[n/2],c=0;
        for(int i: nums){
            c+=(Math.abs(i-med));
        }
        return c;
    }
}
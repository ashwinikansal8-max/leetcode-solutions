class Solution {
    public int minMoves(int[] nums) {
         int min=Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
         }
         if(max==min) return 0;
         int c=0;
         for(int i : nums){
            c+=(i-min);
         }
         return c;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
          set.add(nums[i]);
        }
        
        int ans=0,len=0;
        for(int i : set){
            if(!set.contains(i-1)){
                int j=i;
                   while(set.contains(j))
                   {
                     j++;
                     len++;
                   }
                   ans = Math.max(ans,len);
                   len=0;
            } 
        }
        return ans;
    }
}
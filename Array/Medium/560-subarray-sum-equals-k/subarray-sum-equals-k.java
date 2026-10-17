class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);

        int currSum=0,ans=0;

        for(int num : nums){
            currSum+=num;

            ans += hm.getOrDefault(currSum-k,0);

            hm.put(currSum,hm.getOrDefault(currSum,0)+1);
        }

        return ans; 
    }
}
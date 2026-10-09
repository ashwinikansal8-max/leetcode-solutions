class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n =nums.length;
        if(n==1) return false;

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                 if((i-hm.get(nums[i]))<=k) return true;
                 else 
                 hm.put(nums[i],i);
            }
            else hm.put(nums[i],i);
        }
        return false;
    }
}
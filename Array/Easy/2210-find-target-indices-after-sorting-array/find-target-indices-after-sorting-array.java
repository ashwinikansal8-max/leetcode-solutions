class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> arr = new ArrayList<>();
        int j=0,c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) c++;
            else if(nums[i]<target) j++;
        }
        for(int i=0;i<c;i++){
            arr.add(i+j);
        }
        return arr;
    }
}
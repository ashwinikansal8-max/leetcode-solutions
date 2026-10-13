class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0,r=nums.length-1;
        while(r!=-1 && nums[r]==val) r--;
        if(r<0) return 0;
        while(l<r){
            if(nums[r]==val) r--;
            else if(nums[l]==val){
                nums[l]=nums[r];
                l++; r--;
            }
            else l++;

        }
        if(l==r && nums[l]==val) return r;
        return r+1;

    }
}
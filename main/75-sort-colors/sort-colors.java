class Solution {

    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j] = t;
    }

    public void sortColors(int[] nums) {
        int low=0,high=nums.length-1,mid=0;

        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                mid++;
                low++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }

        }
    }
}
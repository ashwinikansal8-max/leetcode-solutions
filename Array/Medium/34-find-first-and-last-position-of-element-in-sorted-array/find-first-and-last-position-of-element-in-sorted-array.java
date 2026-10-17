class Solution {

    int first(int[] nums, int target){
         int low=0,high=nums.length-1,mid;
        int ans=-1;

        while(low<=high){
            mid= low + (high-low)/2;
             if(nums[mid]==target){
                ans=mid;
                high=mid-1;        
             }
             else if(nums[mid]<target){
                    low=mid+1;
             }
             else high=mid-1;
        }
             return ans;
    }

    int last(int[] nums, int target){
         int low=0,high=nums.length-1,mid;
        int ans=-1;

        while(low<=high){
            mid= low + (high-low)/2;
             if(nums[mid]==target){
                ans=mid;
                low=mid+1;        
             }
             else if(nums[mid]<target){
                    low=mid+1;
             }
             else high=mid-1;
        }
             return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        
        int f = first(nums,target);
        if(f==-1)
        return new int[]{-1,-1};

        int l = last(nums,target);
        return new int[]{f,l};

    }
}
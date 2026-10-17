class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow=nums[0],fast=nums[0];
        do{
             slow=nums[slow];
             fast=nums[nums[fast]];
        }while(slow!=fast);

        int s1=nums[0];
        while(s1!=slow){
             slow=nums[slow];
             s1=nums[s1];
        }
        return s1;
    }
}
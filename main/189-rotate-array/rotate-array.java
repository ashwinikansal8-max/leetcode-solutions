class Solution {
   public static void reverse(int[] nums,int s,int e)
    {
        int i=s,j=e;
        while(j>i)
        { 
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }

    public static void rotate(int[] nums, int k) {
        int l = nums.length;
        reverse(nums,0,l-1);
        reverse(nums,0,(k%l)-1);
        reverse(nums,k%l,l-1);
        System.out.println(Arrays.toString(nums));
    }
}
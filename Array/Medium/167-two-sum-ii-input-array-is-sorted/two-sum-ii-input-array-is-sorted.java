class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        int[] a = new int[2];
        while(l<r)
        {
            if(numbers[l]+numbers[r]==target)
            {
                 a[0]=l+1;
                 a[1]=r+1;
                 break;
            }
            else if(numbers[l]+numbers[r]>target)
            r--;
            else l++;
        }

        return a;
    }
}
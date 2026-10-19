class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3) return false;
        int i=0,j=n-1;
        
        while(i<n-1){
           if(arr[i]<arr[i+1]) i++;
           else break;
        }
        while(j>0){
            if(arr[j]<arr[j-1]) j--;
            else break;
        }
        
        if(i==j && !(i==0 && j==0) && !(i==n-1 && j==n-1)) return true;
        else return false;

    }
}
class Solution {

    int count(int num){
        int c=0;
        while(num>0){
            num = (num&(num-1));
            c++;
        }
        return c;
    }
    public int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i=0;i<=n;i++){
            arr[i]=count(i);
        }

        return arr;
    }
}
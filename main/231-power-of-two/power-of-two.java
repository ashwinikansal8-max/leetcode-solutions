class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if((n&1)==1 || (n==0)) return false;
        while((n&1)!=1){
            n = n>>1;
        }
        if(n==1) return true;
        return false;
    }
}
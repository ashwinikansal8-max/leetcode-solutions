class Solution {
    public boolean hasAlternatingBits(int n) {
        int i=0;
        int b = n&1;
        n = n>>1;
        while(n!=0){
             int c = n&1;
             if(c != 1-b) return false;
             b=c;
             n = n>>1;
        }

        return true;
    }
}
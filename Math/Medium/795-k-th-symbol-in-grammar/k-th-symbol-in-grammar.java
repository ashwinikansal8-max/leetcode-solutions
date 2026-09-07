class Solution {
    public int kthGrammar(int n, int k) {
        k=k-1;
        return value(n,k);
           }

           int value(int n,int k)
           {
             if(n==1) return 0;
             int par = value(n-1,k/2);
             if(k%2==0) return par;
             else return 1-par;
           }
}
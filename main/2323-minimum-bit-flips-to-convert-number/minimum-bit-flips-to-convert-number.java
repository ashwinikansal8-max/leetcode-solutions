class Solution {

    boolean checkbit(int n,int i){
        if(((n>>i)&1)==1) return true;
        else return false;
    }

    public int minBitFlips(int start, int goal) {
        
        int n = start^goal;
        int ans=0;

        while(n>0){
            if((n&1)==1) ans++;

            n = n>>1; 
        }

        return ans;
    }
}



        
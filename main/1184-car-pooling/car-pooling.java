class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxdist=0;
        for(int[] t: trips)
        {
            maxdist = Math.max(maxdist,t[2]);
        }
        int[] diff = new int[maxdist+1];
        diff[0]=0;

        for(int[] t: trips)
        {
            int n = t[0];
            int s = t[1];
            int e = t[2];
            
            if(n>capacity) return false;

            diff[s]+=n;
            diff[e]-=n;
        }
          
        int current=0;
       
        for(int i=0;i<=maxdist;i++)
        {
            current+=diff[i];
            if(current>capacity)
            {
                return false;
            }
        }
        return true;
    }
}
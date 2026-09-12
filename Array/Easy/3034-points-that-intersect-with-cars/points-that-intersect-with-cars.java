class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int maxdist=0;
        for(List<Integer> t: nums)
        {
            maxdist = Math.max(maxdist,t.get(1));
        }
        

        

        int diff[] = new int[maxdist+1];
        diff[0]=0;

        for(List<Integer> t: nums)
        {
            int s = t.get(0);
            int e = t.get(1);
            diff[s]+=1;
            if(e+1<=maxdist) diff[e+1]-=1;
        }
        
        int curr=0,c=0;
        for(int i=1;i<=maxdist;i++)
        {
            curr+=diff[i];
            if(curr>=1) c++;
        }

        return c;
    }
}
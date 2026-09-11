class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        diff[0]=0;
        int[] ans = new int[n];
        int row = bookings.length;

        for(int i=0;i<row;i++)
        {
            int l = bookings[i][0];
            int r = bookings[i][1];
            int s = bookings[i][2];

            diff[l]+=s;
            if(r+1<=n) diff[r+1]-=s;
        }
        
        ans[0]=diff[1];
        for(int i=1;i<n;i++)
        {
            ans[i]=diff[i+1]+ans[i-1];
        }

        return ans;
    }
}
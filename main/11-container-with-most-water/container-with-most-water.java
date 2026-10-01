class Solution {
    public int maxArea(int[] height) {
        int l=0,n=height.length-1,best=0;
        int r=n;
        while(l<r)
        {
            best = Math.max(best,Math.min(height[r],height[l])*(r-l));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return best;
    }
}
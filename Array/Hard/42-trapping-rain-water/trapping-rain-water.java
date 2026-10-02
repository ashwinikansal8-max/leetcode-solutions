class Solution {
    public int trap(int[] height) {
        int r=height.length-1,l=0,rm=0,lm=0;
        int ans=0;
        while(l<r)
        {
            if(height[l]<=height[r])
            {
                if(lm>height[l]) ans+=lm-height[l];
                else lm = height[l];
                l++;
            }
            else{
                if(rm>height[r]) ans+=rm-height[r];
                else rm=height[r];
                r--;
            }
        }
        return ans;
        
    }
}
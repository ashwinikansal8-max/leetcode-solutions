class Solution {

    void recpermute(int idx,int[] nums,List<List<Integer>> ans)
    {        
        if(idx==nums.length)
        {
            List<Integer> ds = new ArrayList<>();
            for(int k : nums)
            {
                ds.add(k);
            }
            ans.add(ds);
            return;
        }

        for(int i=idx;i<nums.length;i++)
        {
            swap(i,idx,nums);
            recpermute(idx+1,nums,ans);
            swap(i,idx,nums);
        }

    }

    void swap(int i,int j,int[] nums)
    {
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recpermute(0,nums,ans);
        return ans;

    }
}
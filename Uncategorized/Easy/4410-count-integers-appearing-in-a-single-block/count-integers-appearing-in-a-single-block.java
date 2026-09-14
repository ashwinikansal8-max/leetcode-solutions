class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> hs = new HashMap<>();
        int i=0;
        for(int t: nums)
        {
            if(!hs.containsKey(t)){
                hs.put(t,new ArrayList<>());
            }

            hs.get(t).add(i);
            i++;
        }
       int ans=0;
       for(List<Integer> t: hs.values()){
        if(t.size()==1) ans++;
        else if(t.size()>1)
        {   
            int c=0;
            for(int j=0;j<t.size()-1;j++)
            {
                if(t.get(j)!=t.get(j+1)-1) c=1;
            }
            if(c==0) ans++;
        }
       }

       return ans;
    }
}
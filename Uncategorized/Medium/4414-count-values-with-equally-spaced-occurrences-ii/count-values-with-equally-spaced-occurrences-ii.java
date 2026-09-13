class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,List<Integer>> hs = new HashMap<>();
        int j=0;
        for(int t: nums)
            {
                if(!hs.containsKey(t)) hs.put(t,new ArrayList<>());
               
                hs.get(t).add(j);
                j++;
            }

        int ans=0;
        for(List<Integer> ids: hs.values())
            {
                if(ids.size()>=3){
                    int c=0;
                    int d = ids.get(1)-ids.get(0);
                     for(int i=1;i<ids.size()-1;i++)
                     {
                         if(ids.get(i+1)-ids.get(i)!=d)
                         {
                             c=1;
                             break;
                         }
                     }
                    if(c==0) ans++;
                }
            }
        return ans;
    }
}
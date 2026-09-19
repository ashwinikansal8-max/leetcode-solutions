class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> a = new ArrayList<>();
        long ans=1;
        a.add(1);

        for(int i=1;i<=rowIndex;i++)
        {   
            ans = ans*(rowIndex-i+1);
            ans=ans/i;
            a.add((int)ans);

        }
        return a;
    }
}
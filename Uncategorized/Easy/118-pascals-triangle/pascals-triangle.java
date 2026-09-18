class Solution {

    List<Integer> rows(int i)
    {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int ans=1;
        for(int j=1;j<i;j++)
        {
            ans = ans*(i-j);
            ans=ans/j;
            row.add(ans);
        }
        return row;
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> a = new ArrayList<>();
         for(int i=1;i<=numRows;i++)
         {
             a.add(rows(i));
         }

         return a;
    }

}
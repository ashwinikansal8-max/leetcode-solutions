class Solution {
    public int countRotations(String s, int k) {
         int score=0,c=0;
         int n=s.length();
         for(int i=0;i<n-1;i++)
         {
            if(s.charAt(i)==s.charAt(i+1)) score++;
         }

         for(int i=0;i<n;i++)
         {
            if(score==k) c++;
            int next = (i+1)%n;
            int prev = (i+n-1)%n;
            
            if(s.charAt(prev)==s.charAt(i)) score++;
            if(s.charAt(next)==s.charAt(i)) score--;
         }

         return c;
    }
}
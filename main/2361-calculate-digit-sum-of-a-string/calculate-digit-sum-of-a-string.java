class Solution {
    public String digitSum(String s, int k) {
        if(s.length()<=k) return s;
int c=0,sum=0;
String a="";
     while(s.length()>k)
     {
         for(int i=0;i<s.length();i++)
        {
            sum = sum + Character.getNumericValue(s.charAt(i));
            c++;
            if(c==k || i==(s.length()-(s.length()%k)-1) || i==s.length()-1)
            {
                a=a+ Integer.toString(sum);
                sum=0;
                c=0;
            }
        }
        s=a;
        a="";
     }
      return s; 
    }
}
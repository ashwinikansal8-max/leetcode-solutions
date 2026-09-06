class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i=0;

        while(i<n && s.charAt(i)==' ') i++;
        
        if(i==n) return 0;  
        
        int c=1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-')
        {
            if(s.charAt(i)=='-') c=-1;
            i++;
        }
        int num=0;
        
        while(i<n && (s.charAt(i)>='0' && s.charAt(i)<='9'))
        {
            int d = s.charAt(i) - '0';
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && d>7))
            {
                return (c==1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
          
          num = num*10 + d;
          i++;
        }
        return num*c;
    }
}
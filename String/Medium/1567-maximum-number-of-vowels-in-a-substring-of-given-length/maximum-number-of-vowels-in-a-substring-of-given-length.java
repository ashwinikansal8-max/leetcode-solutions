class Solution {
    public int maxVowels(String s, int k) {
        int len=0,max=0,n=s.length();
        for(int i=0;i<k;i++)
        {
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') len++;
        }
        
        max = len;

        for(int i=0;i<n-k;i++){

            int c1=0,c2=0;

              if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u') c1++;
              
              if(s.charAt(i+k)=='a'||s.charAt(i+k)=='e'||s.charAt(i+k)=='i'||s.charAt(i+k)=='o'||s.charAt(i+k)=='u') c2++;

              len = len-c1+c2;

              max = Math.max(max,len);
              
        }

        return max;
    }
}
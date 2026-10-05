class Solution {

    boolean isvow(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
        return true;
        else
        return false;
    }

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int l=0,r=s.length()-1;
        while(l<r)
        {
            while(l<r && !isvow(arr[l])) l++;
            while(l<r && !isvow(arr[r])) r--;

            if(l<r && isvow(arr[l]) && isvow(arr[r]))
            {
                char t = arr[l];
                arr[l] = arr[r];
                arr[r]=t;

                l++; r--;
            }


        }


        return new String(arr);
    }
}
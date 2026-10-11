class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2=s2.length();
        if(n2<n1) return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        
        for(int i=0;i<n1;i++){
            cnt1[s1.charAt(i)-'a']++;
            cnt2[s2.charAt(i)-'a']++;
        }
        int match=0;
        for(int i=0;i<26;i++) {
            if(cnt1[i]==cnt2[i]) match++;
        }
        if(match==26) return true;

        
        for(int right=n1;right<n2;right++){
            
            int in = s2.charAt(right)-'a';
            cnt2[in]++;

            if(cnt1[in]==cnt2[in]) match++;
            else if(cnt2[in]==cnt1[in]+1) match--;

            int out = s2.charAt(right-n1)-'a';
            cnt2[out]--;

            if(cnt2[out]==cnt1[out]) match++;
            else if(cnt2[out]==cnt1[out]-1) match--;

            if(match==26) return true;

        }

        return false;

    }
}
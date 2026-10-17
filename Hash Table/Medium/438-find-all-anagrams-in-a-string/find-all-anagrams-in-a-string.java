class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr = new ArrayList<>();
        int[] cnt1 = new int[26];       
        int[] cnt2 = new int[26];
        int n2=s.length(), n1=p.length();
        if(n2<n1) return arr;

        for(int i=0;i<n1;i++){
            cnt1[p.charAt(i)-'a']++;
            cnt2[s.charAt(i)-'a']++;
        }
        int match=0;
        for(int i=0;i<26;i++){
            if(cnt1[i]==cnt2[i]) match++;
        }
        if(match==26) arr.add(0);
        for(int i=n1;i<n2;i++){
            int in = s.charAt(i)-'a';
            cnt2[in]++;

            if(cnt1[in]==cnt2[in]) match++;
            else if(cnt2[in]==cnt1[in]+1) match--;

            int out = s.charAt(i-n1)-'a';
            cnt2[out]--;

            if(cnt1[out]==cnt2[out]) match++;
            else if(cnt2[out]==cnt1[out]-1) match--;

            if(match==26) {arr.add(i-n1+1);}            
        }
        return arr;
    }
}
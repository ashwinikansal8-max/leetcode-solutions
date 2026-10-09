class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length(), n2=magazine.length();
        if(n1>n2) return false;

        int[] freq = new int[26];
        for(int i=0;i<n2;i++){
            char m = magazine.charAt(i);
            freq[m-'a']++;
        }
        
        for(int i=0;i<n1;i++){
            char r = ransomNote.charAt(i);
            freq[r-'a']--;
        }

        for(int i: freq){
            if(i<0) return false;
        }
        return true;
    }
}
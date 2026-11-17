class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        
        int n = strs.length;
        for(int i=0;i<n;i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        List<List<String>> ans= new ArrayList<>();
        for(List<String> a : hm.values()){
            ans.add(a);
        }
        return ans;
    }
}
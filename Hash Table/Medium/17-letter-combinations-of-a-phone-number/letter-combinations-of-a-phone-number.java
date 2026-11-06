class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> hm = new HashMap<>();
        List<String> ans = new ArrayList<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");

        ans.add("");

        for(int i=0;i<digits.length();i++){
            char c = digits.charAt(i);
            int num = c-'0';
            String a= hm.get(num);

            List<String> temp = new ArrayList<>();
            
            for(String currentStr : ans){
                for(int j=0;j<a.length();j++){
                    temp.add(currentStr+a.charAt(j));
                }
            }

            ans =temp;
        }

        return ans;
    }
}
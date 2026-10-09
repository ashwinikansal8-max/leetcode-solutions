class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
         
        HashSet<Integer> result = new HashSet<>();
        for(int i : nums2){
           if(set.contains(i)) result.add(i);
        }

        int[] arr = new int[result.size()];
        int i=0;
        for(int x: result){
            arr[i++]=x;
        }

        return arr;
    }
}
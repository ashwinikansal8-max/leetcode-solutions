class MyCalendarThree {

    TreeMap<Integer,Integer> hm;

    public MyCalendarThree() {
                hm = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        hm.put(startTime, hm.getOrDefault(startTime, 0) + 1);
        hm.put(endTime, hm.getOrDefault(endTime, 0) - 1);
        int active=0;
        int ans = Integer.MIN_VALUE;
        for(int i: hm.values()){
           active+=i;
           ans = Math.max(ans,active);
        }
        return ans;
    }
}

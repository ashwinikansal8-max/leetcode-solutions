class MyCalendar {    

    private TreeMap<Integer,Integer> cal;

    public MyCalendar() {
            cal = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prev = cal.floorKey(startTime);
        Integer next = cal.ceilingKey(startTime);

        if(prev!=null && cal.get(prev)>startTime) return false;

        if(next!=null && next<endTime) return false;

        cal.put(startTime,endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
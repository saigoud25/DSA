729. My Calendar I
https://leetcode.com/problems/my-calendar-i/


/*
->Create a TreeMap to store start as a key and end as a value
*/
class MyCalendar {
    TreeMap<Integer, Integer> map;
    
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        
        if((prev==null || map.get(prev)<=start) && (next==null || end<=next))
        {
            map.put(start, end);
            return true;
        }
        
        return false;
    }
}

732. My Calendar III
https://leetcode.com/problems/my-calendar-iii/

/*
->Create a TreeMap and update it's value
*/
class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    int max;

    public MyCalendarThree() {
        map = new TreeMap<>();
        max = 0;
        map.put(-1, 0);
    }
    
    public int book(int start, int end) {
        map.put(start, map.get(map.floorKey(start)));
        map.put(end, map.get(map.floorKey(end)));
        
        for(int i : map.subMap(start, end).keySet()) {
            int val = map.get(i)+1;
            map.put(i, val);
            max = Math.max(max, val);
        }
        
        return max;
    }
}

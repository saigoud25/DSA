731. My Calendar II
https://leetcode.com/problems/my-calendar-ii/


/*
->First check for the overlaps in booking array,
->If found overlap, check overlap in overlap array
->Add overlaps in overlaps array, each booking in booking array
*/
class MyCalendarTwo {
    ArrayList<int[]> booking;

    public MyCalendarTwo() {
        booking = new ArrayList<>();
        
    }
    
    public boolean book(int start, int end) {
        ArrayList<int[]> overlap = new ArrayList<>();
        for(int[] b : booking) {
            int firstStart = Math.max(start, b[0]);
            int firstEnd = Math.min(end, b[1]);
            
            if(firstStart >= firstEnd) continue;
            
            for(int[] o : overlap) {
                int secondStart = Math.max(firstStart, o[0]);
                int secondEnd = Math.min(firstEnd, o[1]);
                
                if(secondStart < secondEnd) {
                    return false;
                }
            }
            
            overlap.add(new int[]{firstStart, firstEnd});
        }
        booking.add(new int[]{start, end});
        
        return true;
    }
}

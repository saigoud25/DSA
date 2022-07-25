435. Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/
https://leetcode.com/problems/non-overlapping-intervals/discuss/510140/Java-solution-(easy-to-understand-not-most-efficient)

/*
-> First Sort the arrays based on the second value of each array
-> Starting at the second index of interval array, check for the invalid condition where first value of interval is less than the previous interval first value
->If invalid condition occured increment the remove by 1 else store the prev value;
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove = 0, prev = intervals[0][1];
        
        for(int i = 1; i<intervals.length; i++) {
            if(intervals[i][0] < prev) {
                remove++;
            }
            else {
                prev = intervals[i][1];
            }
        }
        
        return remove;
    }
}

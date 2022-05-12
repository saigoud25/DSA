57. Insert Interval
https://leetcode.com/problems/insert-interval/
https://youtu.be/A8NUOmlwOlM

/*
https://youtu.be/A8NUOmlwOlM

->If the newInterval[1] is less than the intervals[i][0]
    ->Add the interval into the arr and add all next intervals from ith position
->If the newInterval greater tha the intervals[i] add the intervals[i] into the arr
->Else, newInterval[0] is Minimum of interval[0] and i[0];
    ->  newInterval[1] is maximum of interval[1] and i[1];
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList();
        
        for(int j = 0; j<intervals.length; j++)
        {
            int[] i = intervals[j];
            if(newInterval[1]<i[0])
            {
                arr.add(newInterval);
                for(int k = j; k<intervals.length; k++)
                {
                    arr.add(intervals[k]);
                }
                return arr.toArray(new int[arr.size()][]);
            }
            else if(newInterval[0]>i[1])
            {
                arr.add(i);
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        
        arr.add(newInterval);
        
        return arr.toArray(new int[arr.size()][]);
    }
}

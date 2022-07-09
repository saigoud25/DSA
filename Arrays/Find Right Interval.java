436. Find Right Interval
https://leetcode.com/problems/find-right-interval/

/*
->Create a TreeMap, which stores the intervals[i][0] as keys and i as index
->Iterate through the intervals, find the equal or first greatest number from the TreeMap, get that index and store in arr
*/
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] arr = new int[intervals.length];
        int ind = 0;
        
        for(int i = 0; i<intervals.length; i++)
        {
            map.put(intervals[i][0], i);
        }
        // System.out.println(map);
        for(int[] i : intervals)
        {
            Integer ele = map.ceilingKey(i[1]);
            if(ele!=null)
            {
                arr[ind++] = map.get(ele);
            }
            else
            {
                arr[ind++] = -1;
            }
        }
        return arr;
    }
}

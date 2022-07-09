452. Minimum Number of Arrows to Burst Balloons
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

/*
->Sort the 2D array
->Check whether i[0] is lessthan the curr[1], if it's lesser, merge both intervals, take max 0th values and min 1th value, if not lesser simply increment count and make present interval as a curr
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int[] curr = points[0];
        for(int[] i : points)
        {
            if(i[0] <= curr[1])
            {
                // curr[0] = Math.max(i[0], curr[0]);
                curr[0] = i[0];
                curr[1] = Math.min(i[1], curr[1]);
            }
            else
            {
                count++;
                curr = i;
            }
        }
        return count+1;
    }
}

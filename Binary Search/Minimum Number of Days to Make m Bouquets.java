1482. Minimum Number of Days to Make m Bouquets
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
https://www.youtube.com/watch?v=pzeIThtobsM

/*
The approach is to check from 1 to max(bloomDay), whether number of days (hit/miss)
First Binary Search from low to max
    ->find whether mid is number of days,
    ->If true, then there may be chance of having number of days less than the mid
        so, make low = mid
    ->If mid is not a number of days, then it may be higher number
        so, make max = mid+1
*/
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int end = Integer.MIN_VALUE, start = Integer.MAX_VALUE;
        for(int i : bloomDay)
        {
            end = Math.max(end, i);
            start = Math.min(start, i);
        }
        while(start<end)
        {
            int mid = (start+end)/2, flow = 0, count = 0;
            System.out.println(start+" "+mid+" "+end);
            for(int i = 0; i<bloomDay.length; i++)
            {
                if(bloomDay[i]>mid)
                {
                    flow = 0;
                }
                else if(++flow >= k)
                {
                    count++;
                    flow = 0;
                }
            }
            if(count<m)
            {
                start = mid+1; 
            }
            else
            {
                end = mid;
            }
        }
        return start;
    }
}

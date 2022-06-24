739. Daily Temperatures
https://leetcode.com/problems/daily-temperatures/

/*
->Method-1 Using Monotonic Stack
->Method-2
->First check i+1 element is greater than the ith element,
    ->If yes, directly add 1 to the ans array
    ->Else, add the i+1th ans to the days, (kind of DP)
    ->Again check i+days is greater than ith element if yes, add days to the array
    ->Else add it's ans to the present days
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Method-2
        int n = temperatures.length-1;
        int[] ans = new int[n+1];
        int hot = 0;
        
        for(int i= n; i>=0; i--)
        {
            int currTemp = temperatures[i];
            if(currTemp>=hot)
            {
                hot = currTemp;
                continue;
            }
            
            int days = 1;
            while(temperatures[i+days]<=currTemp)
            {
                days += ans[i+days];
            }
            ans[i] = days;
        }
        
        return ans;
    }
}

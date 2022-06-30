983. Minimum Cost For Tickets
https://leetcode.com/problems/minimum-cost-for-tickets/


/*
->Using Dynamic Programming, Recursion + Memoization (Top-Down Approach)
->At each index, we would have 3 options, return minimum cost from 3 options
*/
class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];

        return helper(0, days, costs);
    }
    
    int helper(int i, int[] days, int[] costs)
    {
        if(i==days.length) return 0;
        
        if(dp[i] != 0) return dp[i];
        
        int ans = helper(i+1, days, costs)+costs[0];
        
        int t = i;
        while(days[t]<=days[i]+6)
        {
            t++;
            if(t==days.length)
            {
                break;
            }
        }
        ans = Math.min(ans, helper(t, days, costs)+costs[1]);
        
        t = i;
        while(days[t]<=days[i]+29)
        {
            t++;
            if(t==days.length)
            {
                break;
            }
        }
        
        ans = Math.min(ans, helper(t, days, costs)+costs[2]);
        
        return dp[i] = ans;
    }
}

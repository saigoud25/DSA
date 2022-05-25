322. Coin Change
https://leetcode.com/problems/coin-change/
https://youtu.be/myPeWb3Y68A

/*
->Using DP, Recursion+Memoization
https://youtu.be/myPeWb3Y68A

->Pick or Not pick Method, If index i is picked you can again pick the same index
*/
class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        int ans = helper(coins.length-1, coins, amount);
        
        if(ans >= 1e9) return -1;
        return ans;
    }
    
    int helper(int i, int[] coins, int amount)
    {
        if(amount==0) return 0;
        
        if(i==-1)
        {   
            return (int)1e9;
        }
        if(dp[i][amount] != 0) return dp[i][amount];
        
        int np = helper(i-1, coins, amount);
        
        int p = Integer.MAX_VALUE;
        
        if(amount-coins[i] >= 0) p = helper(i, coins, amount-coins[i])+1;
        
        return dp[i][amount] = Math.min(np, p);
    }
}

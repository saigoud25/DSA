188. Best Time to Buy and Sell Stock IV
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

/*
->Using DP
*/
class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[2][prices.length][k+1];
        
        // if(n<=1 || k<1) return 0;
        
        for(int[][] i : dp) {
            for(int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        
        return helper(0, prices, k, 0);
    }
    
    public int helper(int i, int[] prices, int k, int buy) {
        
        if((i == prices.length) || (k==0)) {
            return 0;
        }
        
        // System.out.println(i+"-"+prices[i]+"-"+k);
        
        if(dp[buy][i][k] != -1) {
            return dp[buy][i][k];
        }
        
        int ans = -1;
        
        if(buy==1) {
            //We have two options if previos transaction was a buy, can sell that day or hold
            
            //Selling
            ans = Math.max(ans, helper(i+1, prices, k-1, 0)+prices[i]);
            
            //Holding
            ans = Math.max(ans, helper(i+1, prices, k, 1));
        } 
        else {
            //We have two options if previous transaction was a sell, can buy or skip the day
            
            //Buying
            ans = Math.max(ans, helper(i+1, prices, k, 1)-prices[i]);
            
            //Skipping the day
            ans = Math.max(ans, helper(i+1, prices, k, 0));
        }
        
        return dp[buy][i][k] = ans;
    }
}

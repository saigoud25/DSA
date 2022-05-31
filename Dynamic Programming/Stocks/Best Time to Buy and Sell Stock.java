121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
->For each index check min value from left and subtract minvalue by ith value and compare with the max_profit
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int max_profit = 0;
        
        for(int i = 0; i<prices.length; i++)
        {
            if(prices[i]<min)
            {
                min = prices[i];
            }

            if( (prices[i]-min) > max_profit )
            {
                max_profit = prices[i]-min;
            }       
        }
        
        return max_profit;
    }
}

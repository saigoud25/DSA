518. Coin Change 2
https://leetcode.com/problems/coin-change-2/
https://youtu.be/HgyouUi11zk

/*
->Using Dynamic Programming
https://youtu.be/HgyouUi11zk

->Pick and NotPick method
*/

class Solution {
    
    int[][] dp;
    public int change(int amount, int[] coins) {
        // dp = new int[coins.length][amount+1];
        
        //Tabular method with space optimization
        
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];
        
        for(int a = 0; a<=amount; a++)
        {
            if(a%coins[0]==0)
            {
                prev[a] = 1;
            }
        }
        
       
        for(int i = 1; i<coins.length; i++)
        {
            for(int a  = 0; a<=amount; a++)
            {
                int np = prev[a];
                
                int p = 0;
                
                if(coins[i]<=a)
                {
                    p = cur[a-coins[i]];
                }
                
                cur[a] = np+p;
            }
            
            prev = cur;
        }
        
        return prev[amount];
        
        //Taular method without space optimization
        
        // for(int a = 0; a<=amount; a++)
        // {
        //     if(a%coins[0]==0)
        //     {
        //         dp[0][a] = 1;
        //     }
        // }
        
//         for(int i = 1; i<coins.length; i++)
//         {
//             for(int a = 0; a<=amount; a++)
//             {
//                 int np = dp[i-1][a];
//                 int p = 0;
        
//                 if(coins[i]<=a)
//                 {
//                     p = dp[i][a-coins[i]];
//                 }
                
//                 dp[i][a] = np+p;
//             }
//         }
        
        // return dp[coins.length-1][amount];
        
        // return helper(coins.length-1, coins, amount);
    }
    
    //Recursion+Momoization
    int helper(int i, int[] coins, int amount)
    {
        if(amount==0) return 1;
        
        if(i==-1)
        {
            return 0;
        }
        
        if(dp[i][amount] != 0) return dp[i][amount];
        
        int np = helper(i-1, coins, amount);
        
        int p = 0;
        
        if(amount-coins[i]>=0)
        {
            p = helper(i, coins, amount-coins[i]);
        }
        
        return dp[i][amount] = np+p;
    }
}

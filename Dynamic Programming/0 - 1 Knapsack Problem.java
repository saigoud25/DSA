0 - 1 Knapsack Problem 
https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
https://youtu.be/GqOmJHQZivw


/*
->Using Dynamic Programming
https://youtu.be/GqOmJHQZivw

*/
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int dp[][];
    
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         dp = new int[n][W+1];
         //Tabulation Method
         for(int i = wt[0]; i<=W; i++)
         {
             dp[0][i] = val[0];
         }
         
         for(int i = 1; i<n; i++)
         {
             for(int w = 0; w<=W; w++)
             {
                 int notPick = dp[i-1][w];
                 int pick = Integer.MIN_VALUE;
                 if(wt[i]<=w) pick = dp[i-1][w-wt[i]]+val[i];
                 
                 dp[i][w] = Math.max(pick, notPick);
             }
         }
        
         return dp[n-1][W];
        //  return helper(n-1, W, wt, val);
    } 
    //Recursion+Memoization Method
    static int helper(int i, int W, int wt[], int val[])
    {
        if(i==0)
        {
            if(wt[0]<=W) return val[0];
            return 0;
        }
        if(dp[i][W]!=0) return dp[i][W];
        int notPick = helper(i-1, W, wt, val);
        
        int pick = Integer.MIN_VALUE;
        if(wt[i]<=W) pick = helper(i-1, W-wt[i], wt, val)+val[i];
        
        dp[i][W] = Math.max(pick, notPick);
        return dp[i][W];
    }
}

Knapsack with Duplicate Items 
https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1/#
https://youtu.be/OgvOZ6OrJoY

/*
->Using Dynamic Programming
https://youtu.be/OgvOZ6OrJoY

->Pick or NotPick method,
->If we pick add the val[i] to the pick variable
*/
class Solution{
    
    static int[][] dp;
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        dp = new int[N][W+1];
        
        return helper(N-1, W, val, wt);
    }
    
    //Recursion+Memoization
    static int helper(int i, int w, int[] val, int[] wt)
    {
        if(i==0)
        { 
            return ((int)(w/wt[0]))*val[0];
        }
        
        if(dp[i][w] != 0) return dp[i][w];
        
        int np = helper(i-1, w, val, wt);
        
        int p = 0;
        
        if(w-wt[i]>=0)
        {
            p = helper(i, w-wt[i], val, wt)+val[i];
        }
        
        return dp[i][w] = Math.max(np, p);
    }
}

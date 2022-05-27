Rod Cutting
https://practice.geeksforgeeks.org/problems/rod-cutting0840/1#
https://youtu.be/mO8XpGoJwuo


/*
->Using Dynamic Programming
https://youtu.be/mO8XpGoJwuo

->Did Using Recursion+Memoization
->Pick and NotPick method, add price[i] to pick when it is choosen
->Can be done by Tabulation Method
*/
class Solution{
    int[][] dp;
    public int cutRod(int cuts[], int n) {
        //code here
        dp = new int[cuts.length][n+1];
        
        return helper(cuts.length-1, n, cuts);
    }
    
    int helper(int i, int n, int[] cuts)
    {
        if(i==0)
        {
            return n*cuts[0];
        }
        
        if(dp[i][n] != 0) return dp[i][n];
        int np = helper(i-1, n, cuts);
        
        int p = Integer.MIN_VALUE;
        
        if(i+1<=n)
        {
            p = helper(i, n-(i+1), cuts)+cuts[i];
        }
        
        return dp[i][n] = Math.max(np, p);
    }
}

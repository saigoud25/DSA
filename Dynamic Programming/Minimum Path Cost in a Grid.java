2304. Minimum Path Cost in a Grid
https://leetcode.com/problems/minimum-path-cost-in-a-grid/


/*
->Using Dynamic Programming, Minimum Falling Path Sum Method
->Find the minimum Path from i-1 row
*/
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int i = grid.length;
        int j = grid[0].length;
        int[][] dp = new int[i][j];
        
        dp[0] = grid[0];
        
        for(int ii = 1; ii<i; ii++)
        {
            for(int jj = 0; jj<j; jj++)
            {
                int min = Integer.MAX_VALUE;
                
                for(int k = 0; k<j; k++)
                {
                    int ele = grid[ii-1][k];
                    int temp = moveCost[ele][jj] + dp[ii-1][k] + grid[ii][jj];
                    min = Math.min(temp, min);
                }
                
                dp[ii][jj] = min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k<j; k++)
        {
            ans = Math.min(dp[i-1][k], ans);
        }
        
        return ans;
    }
}

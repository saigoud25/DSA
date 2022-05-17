64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/

/*
->Using Dynamic Programming

dp[i][j] is Minimum of (dp[i-1][j] or dp[i][j])+grid[i]

->Return the last index value
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        int sum = 0;
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i<row; i++)
        {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i = 1; i<col; i++)
        {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        
        for(int i = 1; i<row; i++)
        {
            for(int j = 1; j<col; j++)
            {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[row-1][col-1];
    }
}

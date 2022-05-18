1289. Minimum Falling Path Sum II
https://leetcode.com/problems/minimum-falling-path-sum-ii/


/*
->Using Dynamic Programming
->Find the minimum element in upper row except jth + grid[i][j] in dp[i][j]
->Find the minimum elemtn in last row of dp and return it
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ans = Integer.MAX_VALUE;
        dp[0] = matrix[0];
        
        for(int i = 1; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                int one = Integer.MAX_VALUE;
                for(int k = 0; k<col; k++)
                {
                    if(k!=j)
                    {
                        one = Math.min(one, dp[i-1][k]);
                    }
                }
                
                dp[i][j] = one+matrix[i][j];
            }
        }
        for(int i : dp[row-1])
        {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}

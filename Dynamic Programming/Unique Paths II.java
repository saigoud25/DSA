63. Unique Paths II
https://leetcode.com/problems/unique-paths-ii/

/*
->Using Dynamic Programming 
->Same as Unique Paths qn
->make dp[i][j] = 0, when there is an obstacle in a Grid[i][j]
*/

class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        dp = new int[row][col];
        
        for(int i = 0; i<col; i++)
        {
            if(obstacleGrid[0][i]==1) break;
            
            dp[0][i] = 1;
        }
        
        for(int j = 0; j<row; j++)
        {
            if(obstacleGrid[j][0]==1) break;
            
            dp[j][0] = 1;
        }
        for(int i = 1; i<row; i++)
        {
            for(int j = 1; j<col; j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        
        return dp[row-1][col-1];
    }
}

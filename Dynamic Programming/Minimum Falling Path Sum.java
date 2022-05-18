931. Minimum Falling Path Sum
https://leetcode.com/problems/minimum-falling-path-sum/

/*
->Using Dynamic Programming
->Take the minimum of upper three elements + grid[i][j] in the dp[i][j]
->Find the minimum element in the last row of dp and return it
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
                int one = Integer.MAX_VALUE, two = one, three = one;
                if(j-1>=0)
                {
                    one = dp[i-1][j-1];
                }
                two = dp[i-1][j];
                if(j+1<col)
                {
                    three = dp[i-1][j+1];
                }
                
                dp[i][j] = Math.min(three, Math.min(two, one))+matrix[i][j];
            }
        }
        for(int i : dp[row-1])
        {
            ans = Math.min(ans, i);
        }
        // System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}

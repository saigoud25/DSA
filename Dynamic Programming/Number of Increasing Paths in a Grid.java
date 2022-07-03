2328. Number of Increasing Paths in a Grid
https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
https://youtu.be/BKhZOTrCa6E


/*
https://youtu.be/BKhZOTrCa6E
->Using DP + DFS
->Same as Longest Increasing Path, but add the self paths each time
*/
class Solution {
    int[][] dp;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    long mod = 1000000007;
    public int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];
        long ans = 0;
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                ans = (ans + numberPaths(i, j, grid))%mod;
            }
        }
        return (int)ans;
    }
    public int numberPaths(int i, int j, int[][] grid)
    {
        if(dp[i][j] != 0) return dp[i][j];
        long ans = 1;
        for(int k = 0; k<4; k++)
        {
            int i1 = i+dir[k][0];
            int j1 = j+dir[k][1];
            
            if(i1<0 || j1<0 || i1>=grid.length || j1>=grid[0].length || grid[i][j]>=grid[i1][j1])
            {
                continue;
            }
            ans = (ans + numberPaths(i1, j1, grid))%mod;
        }
        
        return dp[i][j] = (int)ans;
    }
}

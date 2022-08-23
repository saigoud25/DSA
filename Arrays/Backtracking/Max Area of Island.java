695. Max Area of Island
https://leetcode.com/problems/max-area-of-island/

/*
->Traverse when 1 appeared, 
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, helper(i, j, grid));
                }
            }
        }
        
        return max;
    }
    
    public int helper(int i, int j, int[][] grid) {
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0) {
            return 0;
        }
        grid[i][j] = 0;
         
        int ans = helper(i, j+1, grid) + helper(i+1, j, grid) + helper(i, j-1, grid) + helper(i-1, j, grid);

        return ans+1;
    }
}

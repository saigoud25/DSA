417. Pacific Atlantic Water Flow
https://leetcode.com/problems/pacific-atlantic-water-flow/

/*
https://youtu.be/NaBu9YgbaDM

->Find the all possible Pacific Ocean cells
->Find the all possible Atlantic Ocean cells
->return the cells which are in Pacific and Atlantic arrays
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        
        for(int i = 0; i<m; i++) {
            dfs(0, i, Integer.MIN_VALUE, heights, pacific);
            
            dfs(n-1, i, Integer.MIN_VALUE, heights, atlantic);
        }
        
        for(int i = 0; i<n; i++) {
            dfs(i, 0, Integer.MIN_VALUE, heights, pacific);
            
            dfs(i, m-1, Integer.MIN_VALUE, heights, atlantic);
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int i, int j, int prev, int[][] grid, boolean[][] ocean) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]<prev || ocean[i][j]) {
            return;
        }
        
        ocean[i][j] = true;
        
        dfs(i, j+1, grid[i][j], grid, ocean);
        dfs(i+1, j, grid[i][j], grid, ocean);
        dfs(i-1, j, grid[i][j], grid, ocean);
        dfs(i, j-1, grid[i][j], grid, ocean);
    }
}

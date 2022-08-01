980. Unique Paths III
https://leetcode.com/problems/unique-paths-iii/

/*
->First count the blocked grids, increment the count
->find the starting square, from then start the dfs
->dfs the 4 sides and increment the count
->When reached grid[i][j]==2, check whether count == n*m(total grids) if satisfies return 1 else 0
*/
class Solution {
    int count = 0;
    public int uniquePathsIII(int[][] grid) {
        int ans = 0;
        for(int[] i : grid) {
            for(int j : i) {
                if(j==-1) count++;
            }
        }
        
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    return dfs(i, j, grid);
                }
            }
        }
        
        return 0;
    }
    
    public int dfs(int i, int j, int[][] grid) {
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]==-1) {
            return 0;
        }
        
        if(grid[i][j] == 2) {
            // System.out.println(count);
            if(count==(grid[0].length*grid.length)) return 1;
            else return 0;
        }
        
        count++;
        
        int sum = 0;
        grid[i][j] = -1;
        sum = dfs(i+1, j, grid) + dfs(i-1, j, grid) + dfs(i, j+1, grid) + dfs(i, j-1, grid);
        grid[i][j] = 0;
        
        count--;
        
        return sum;
        
    }
}

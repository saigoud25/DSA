1706. Where Will the Ball Fall
https://leetcode.com/problems/where-will-the-ball-fall/

/*
->Using DFS Traversal
->If the current element is 1, check whether right element is also 1,
    and go to diagonally right index.
->If the current element is -1, chekc whether left element is also -1,
    and go to diagonally left index.
->Check the base condition
*/
class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i<n; i++) {
            res[i] = dfs(i, 0, i, grid, res);
        }
        return res;
    }
    
    public int dfs(int ball, int i, int j, int[][] grid, int[] res) {
        //Base condition
        if(i==grid.length) {
            if(j>=0 && j<grid[0].length) {
                res[ball] = j;
                return j;
            }
            return -1;
        }

        if(grid[i][j]==1 && j+1<grid[0].length && grid[i][j+1]==1) {
            return dfs(ball, i+1, j+1, grid, res);
        } else if(grid[i][j]==-1 && j-1>=0 && grid[i][j-1]==-1) {
            return dfs(ball, i+1, j-1, grid, res);
        } 
        
        return -1;
    }
}

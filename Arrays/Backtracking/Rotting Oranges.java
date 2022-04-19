/*
994. Rotting Oranges
https://leetcode.com/problems/rotting-oranges/

->By using Backtracking, Finding Island method
->Find the distance between fresh orange and rotten orange
->Ans will be the highest distance among all oranges
->If Ans is 101+, return -1, which means it is unreachable
->If countFresh is 0, return 0, i.e., there are no fresh oranges in the grid
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int min = -1;
        int countFresh = 0;
        
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    int ans = func(grid, i, j);
                    if(ans < 101)
                    {
                        min = Math.max(ans, min);
                    }
                    else
                    {
                        return -1;
                    }
                    countFresh++;
                }
            }
        }
        if(countFresh==0) return 0;
        
        return min;
    }
    int func(int[][] grid, int i, int j)
    {   
        //check for legal location
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0)
        {
            return 101;
        }
        if(grid[i][j] == 2) return 0;
        
        grid[i][j] = 0;
        int min = 101;
        
        min = Math.min(min, func(grid, i, j+1));
        min = Math.min(min, func(grid, i, j-1));
        min = Math.min(min, func(grid, i+1, j));
        min = Math.min(min, func(grid, i-1, j));
        
        grid[i][j] = 1;
        return min+1;
    }
}

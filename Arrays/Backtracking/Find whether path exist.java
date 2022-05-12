Find whether path exist
https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1#

/*
->Using Backtracking
->start the helper function when the grid[i][j]==1
->return true if the grid[i][j]==2
*/

class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        for(int i = 0 ; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    return helper(grid, i , j);
                }
            }
        }
        return false;
    }
    boolean helper(int[][] grid, int i, int j)
    {
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]==0)
        {
            return false;
        }
        
        int d =  grid[i][j];
        if(d==2) return true;
        
        grid[i][j] = 0;
        
        if(helper(grid, i, j+1) || helper(grid, i-1, j) || helper(grid, i+1, j) || helper(grid, i, j-1))
        {
            return true;
        }
        grid[i][j] = d;
        
        return false;
    }
}

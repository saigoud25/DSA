200. Number of Islands
https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    func(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    
    void func(char[][] grid, int i, int j)
    {   
        //check for legal location
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0')
        {
            return;
        }
        
        grid[i][j] = '0';
        
        func(grid, i, j+1);
        func(grid, i, j-1);
        func(grid, i+1, j);
        func(grid, i-1, j);
    }
}

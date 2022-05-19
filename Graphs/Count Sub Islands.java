1905. Count Sub Islands
https://leetcode.com/problems/count-sub-islands/

/*
->If there is 1 in the grid2, 
    ->Traverse complete Island
    ->If the grid2[i][j] != grid1[i][j] found, mark val=1
    ->Increment the count if the val=0 only, if the val is 1, it's not a sub-island
*/
class Solution {
    int val = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        
        for(int i = 0; i<grid2.length; i++)
        {
            for(int j = 0; j<grid2[0].length; j++)
            {
                if(grid2[i][j]==1)
                {
                    val = 0;
                    helper(i, j, grid1, grid2);
                    if(val==0) count++;
                }
            }
        }
        
        return count;
    }
    
    void helper(int i, int j, int[][] grid1, int[][] grid2)
    {
        if(i<0 || i>=grid2.length || j<0 || j>=grid2[0].length || grid2[i][j]==0)
        {
            return;
        }
        
        if(grid1[i][j]!=grid2[i][j]) val = 1;
        
        grid2[i][j] = 0;
        
        helper(i, j+1, grid1, grid2);
        helper(i-1, j, grid1, grid2);
        helper(i+1, j, grid1, grid2);
        helper(i, j-1, grid1, grid2);
        
        return;
    }
}

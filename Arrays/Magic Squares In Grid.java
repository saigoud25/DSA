840. Magic Squares In Grid
https://leetcode.com/problems/magic-squares-in-grid/

/*
->Simple Straight Forward Approach
->At each starting index, check whether it is possible to form magic square
->To check whether it's a magic square, 
    ->sum of each row should be 15
    ->sum of each column should be 15
    ->the middle element should be 5
    ->left and right diagonal should be equal
    ->No two elements in the square should be equal
    ->If the square satisfies all conditions increment the count
*/
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i<=(m-3); i++) {
            for(int j = 0; j<=(n-3); j++) {
                if(grid[i+1][j+1] != 5) continue;
                boolean sum1 = true;
                boolean sum2 = true;
                
                for(int x = i; x<i+3; x++) {
                    int temp = 0;
                    for(int y = j; y<j+3; y++) {
                        if(0<grid[x][y] && grid[x][y]<10) {
                            temp += grid[x][y];
                        }
                    }
                    if(temp != 15) 
                    {
                        sum1 = false;
                    }
                }
                
                for(int y = j; y<j+3; y++) {
                    int temp = 0;
                    for(int x = i; x<i+3; x++) {
                        if(0<grid[x][y] && grid[x][y]<10) {
                            temp += grid[x][y];
                        }
                    }
                    if(temp != 15) {
                        sum2 = false;
                    }
                }
                
                int left = grid[i][j]+grid[i+2][j+2];
                int right = grid[i][j+2]+grid[i+2][j];
                
                if(sum1 && sum2 && left==right && grid[i][j]!=grid[i][j+1]) count++;
            }
        }
        
        return count;
    }
}

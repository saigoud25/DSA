130. Surrounded Regions
https://leetcode.com/problems/surrounded-regions/

/*
->Only check corner positions
->If the position is 'O', call the helper function
->Helper function replaces all adjacent 'O' elements to '1'
->Replace all '1' with '0' and left over '0' with 'X'
*/

class Solution {
    public void solve(char[][] board) {
        int i = 0;
        while(i<board.length)
        {
            int j = 0;
            while(j<board[0].length)
            {
                if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1)
                {
                    if(board[i][j] == 'O')
                    {
                        helper(board, i, j);
                    }
                }
                j++;
            }
            i++;
        }
        
        for(i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1')
                {
                    board[i][j] = 'O';
                }
            }
        }
        
        return;
    }
    void helper(char[][] board, int row, int col)
    {
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] == 'X' 
        ||  board[row][col] == '1')
        {
            return;
        }
        
        board[row][col] = '1';
        
        helper(board, row-1, col);
        helper(board, row, col+1);
        helper(board, row+1, col);
        helper(board, row, col-1);

        return;
    }
}

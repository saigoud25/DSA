289. Game of Life
https://leetcode.com/problems/game-of-life/

/*
->First count the live neighbors
->if for live cell count is less than 2, mark that position as -1 (live to dead cell) 
->if for live cell count is 2 or 3, pass
->if for live cell count is more than 3, mark that position as -1
->if for dead cell count is equal to 3, mark that position as 2 (dead to live cell)
->Now change the temporary values of board
->if position is -1 make it as 0
->if position is 2 make it as 1
*/
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                int count = 0;
                if(i-1>=0 && j-1>=0)
                {
                    //1
                    if(board[i-1][j-1]==1 || board[i-1][j-1]==-1)
                    {
                        count++;
                    }
                }
                if(i-1>=0)
                {
                    //2
                    if(board[i-1][j]==1 || board[i-1][j]==-1)
                    {
                        count++;
                    }
                }
                if(i-1>=0 && j+1<n)
                {
                    //3
                    if(board[i-1][j+1]==1 || board[i-1][j+1]==-1)
                    {
                        count++;
                    } 
                }
                if(j-1>=0)
                {
                    //4
                    if(board[i][j-1]==1 || board[i][j-1]==-1)
                    {
                        count++;
                    } 
                }
                //
                if(j+1<n)
                {
                    //5
                    if(board[i][j+1]==1 || board[i][j+1]==-1)
                    {
                        count++;
                    } 
                }
                if(i+1<m && j-1>=0)
                {
                    //6
                    if(board[i+1][j-1]==1 || board[i+1][j-1]==-1)
                    {
                        count++;
                    } 
                }
                if(i+1<m)
                {
                    //7
                    if(board[i+1][j]==1 || board[i+1][j]==-1)
                    {
                        count++;
                    }   
                }
                if(i+1<m && j+1<n)
                {
                    //8
                    if(board[i+1][j+1]==1 || board[i+1][j+1]==-1)
                    {
                        count++;
                    } 
                }
                // System.out.println(count);
                if(board[i][j]==1)
                {
                    if(count<2 || count>3)
                    {
                        board[i][j] = -1;
                    }
                }
                else if(count==3)
                {
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(board[i][j]==-1)
                {
                    board[i][j] = 0;
                }
                else if(board[i][j]==2)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}

79. Word Search
https://leetcode.com/problems/word-search/


/*
->Using Backtracking, count the forest method
->The array should be fresh in every iteration
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(board[i][j]==word.charAt(0) && helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean helper(char[][] board, String word, int i, int j, int len)
    {
        if(len==word.length())
        {
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(len))
        {
            return false;
        }
        
        board[i][j] ^= 1;

        boolean flag = (
                helper(board, word, i, j+1, len+1) ||
                helper(board, word, i+1, j, len+1) ||
                helper(board, word, i-1, j, len+1) ||
                helper(board, word, i, j-1, len+1)
            );
        
        board[i][j] ^= 1;
        
        return flag;
    }
}

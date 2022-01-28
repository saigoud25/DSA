240. Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        
        int row = mat[0].length-1;
        int col = mat.length-1;
        
        //
        int start = 0, end = row;
        while(start<=col && end>=0)
        {
            if(mat[start][end]==target) return true;
            else if(mat[start][end]<target) start++;
            else end--;
        }
        
        return false;
    }
}

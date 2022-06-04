304. Range Sum Query 2D - Immutable
https://leetcode.com/problems/range-sum-query-2d-immutable/
https://youtu.be/rkLDDxOcJxU

/*
->Using Pre-Sum Method
https://youtu.be/rkLDDxOcJxU

->First Calculate the Pre sum of matrix, first calculate the row wise then column wise
->From the Total sum, remove the Sum of upper ractangle and Left rectange and add the repeating sum(i-1, j-1)
*/
class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++)
        {
            for(int j = 1; j<matrix[0].length; j++)
            {
                matrix[i][j] += matrix[i][j-1]; 
            }
        }
        for(int j = 0; j<matrix[0].length; j++)
        {
            for(int i = 1; i<matrix.length; i++)
            {
                matrix[i][j] += matrix[i-1][j]; 
            }
        }
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        int fullSum = matrix[row2][col2];
        int up = row1!=0 ? matrix[row1-1][col2] : 0;
        int left = col1!=0 ? matrix[row2][col1-1] : 0;
        int ext = (row1!=0 && col1!=0) ? matrix[row1-1][col1-1] : 0;
        sum = fullSum - (up+left-ext);
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

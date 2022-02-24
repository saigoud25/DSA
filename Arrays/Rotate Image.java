48. Rotate Image
https://leetcode.com/problems/rotate-image/

/*
->Transpose the matrix
->Rotate every row of a transposed matrix
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<=i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }  
        }
        for(int i = 0; i<n; i++)
        {
            int s = 0, e = n-1;
            while(s<e)
            {
                int temp = matrix[i][e];
                matrix[i][e] = matrix[i][s];
                matrix[i][s] = temp;
                s++;
                e--;
            }
        }
    }
}

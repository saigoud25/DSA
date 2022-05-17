62. Unique Paths
https://leetcode.com/problems/unique-paths/

/*
->Using DP
https://youtu.be/sdE0A2Oxofw

f(m, n) = f(m-1, n)+f(m, n-1);
->Sum of left and down gives current ans
*/

class Solution {
    int[][] arr;
    public int uniquePaths(int m, int n) {
        arr = new int[m][n];
        
        //Tabular Method
        for(int i = 0; i<m; i++)
        {
            arr[i][0] = 1;
        }
        for(int j = 0; j<n; j++)
        {
            arr[0][j] = 1;
        }
        
        for(int i = 1; i<m; i++)
        {
            for(int j = 1; j<n; j++)
            {
                arr[i][j] = arr[i][j-1]+arr[i-1][j];
            }
        }
        
        return arr[m-1][n-1];
        
        // return func(m, n, m, n);
    }
    
    //Recursion+Memoization
    int func(int i, int j, int m, int n)
    {
        
        if(i==1 && j==1)
        {
            return 1;
        }
        if(i<=0 || j<=0) return 0;
        if(arr[i][j]!=0) return arr[i][j];
        
        arr[i][j] = func(i, j-1, m, n)+func(i-1, j, m, n);
        
        return arr[i][j];
    }
}

474. Ones and Zeroes
https://leetcode.com/problems/ones-and-zeroes/


/*
->Using Dynamic Programming (Recursion & Memoization)
->Pick and Not Pick method, add +1 for pick recursion call
*/

class Solution {
    int[][][] arr;
    public int findMaxForm(String[] strs, int m, int n) {
        arr = new int[strs.length][m+1][n+1];
        return dp(0, strs, m, n);
    }
    int dp(int i, String[] strs, int m, int n)
    {
        if(m<0 || n<0) return Integer.MIN_VALUE;
        
        if(i==strs.length)
        {
            if(m>=0 && n>=0)
            {
                return 0;
            }
            else return Integer.MIN_VALUE;
        }
        
        if(arr[i][m][n] != 0) return arr[i][m][n];
        
        int zero = 0, one = 0;
        
        for(char ch : strs[i].toCharArray())
        {
            if(ch=='0') zero++;
            else one++;
        }
        
        int np = dp(i+1, strs, m, n);
        
        int p = dp(i+1, strs, m-zero, n-one)+1;

        return arr[i][m][n] = Math.max(np, p);
    }
}

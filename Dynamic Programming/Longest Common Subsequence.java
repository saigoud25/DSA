1143. Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/
https://youtu.be/NPZn9jBrX8U

/*
->Using Dynamic Programming
https://youtu.be/NPZn9jBrX8U

->If the chatacters of given indexes is equal, decrement i and j by 1 and add +1 to the answer
->If not match, decrement either i or j and return maxmimum of both function calls
*/
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        
        //Tabular Mathod
        for(int i = 1; i<=text1.length(); i++)
        {
            for(int j = 1; j<=text2.length(); j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
        // return helper(text1.length()-1, text2.length()-1, text1, text2);
    }
    
    //Recursion + Memoization
    int helper(int i, int j, String s1, String s2)
    {
        if(i<0 || j<0) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
        {
            return helper(i-1, j-1, s1, s2)+1;
        }
        
        return dp[i][j] = Math.max(helper(i-1, j, s1, s2), helper(i, j-1, s1, s2));
    }
}

583. Delete Operation for Two Strings
https://leetcode.com/problems/delete-operation-for-two-strings/

/*
->Using dp, Longest Common Subsequence (LCS)
->Find LCS and from length of word1 remove lcs and from length of word2 remove lcs, add both remaining lengths
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i = 1; i<=n1; i++)
        {
            for(int j = 1; j<=n2; j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return n1-dp[n1][n2]+n2-dp[n1][n2];
    }
}

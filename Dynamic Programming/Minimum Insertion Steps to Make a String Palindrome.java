1312. Minimum Insertion Steps to Make a String Palindrome
https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

/*
->Find the Longest Common Subsequence of given s and reverse of s string
->Length of String - Length of LCS will be the answer
*/
class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        
        if(s.equals(rev)) {
            return 0;
        }
        
        int m = s.length();
        int n = m;
        int[][] dp = new int[m+1][m+1];
        
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=m; j++) {
                if(s.charAt(i-1)==rev.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return m-dp[m][m];
        
    }
}

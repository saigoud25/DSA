72. Edit Distance
https://leetcode.com/problems/edit-distance/
https://youtu.be/fJaKO8FbDdo


/*
->Using Dynamic Programming
https://youtu.be/fJaKO8FbDdo

->If characters are matching, check for i-1, j-1
->Then 
    ->to insert a character, check for func(i, j-1)+1;
    ->to delete a character, check for func(i-1, j)+1;
    ->to replace a character, check for func(i-1, j-1)+1;
    ->The ans should be min(insert, delete, replace)
*/

class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++) dp[i][0] = i;
        for(int j = 0; j<=m; j++) dp[0][j] = j;
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        // for(int[] i : dp) System.out.println(Arrays.toString(i));
        return dp[n][m];
        // return helper(i-1, j-1, word1, word2);
    }
    int helper(int i, int j, String word1, String word2)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j] != 0) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) return helper(i-1, j-1, word1, word2);
        
        int ins = helper(i, j-1, word1, word2)+1;
        int del = helper(i-1, j, word1, word2)+1;
        int rep = helper(i-1, j-1, word1, word2)+1;
        
        return dp[i][j] = Math.min(Math.min(ins, del), rep);
    }
}

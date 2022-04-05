5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
https://youtu.be/UflHuQj6MVA

/*
https://youtu.be/UflHuQj6MVA
->Fill all diagonal values as 1, as each element itself is a palindrome
->Fill adjacent two elements as 1 if palindrome, if not fill 0
->Make an dp array, if an position dp[i][j]==1, it means i is start, j is end of substring
->first check the last two characters of string, if they are equal,
    ->Check i+1 and j-1 is equal, i.e., if check dp[i+1][j-1] is 1
    ->If both are true, the string is a palindrome, mark position as 1
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = i; j<=i+1 && j<n; j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j] = 1;
                    if((j+1)-i>max)
                    {
                        max = (j+1)-i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        for(int i = 2; i<n; i++)
        {
            for(int j = 0; (j+i)<n; j++)
            {
                if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]==1)
                {
                    dp[j][j+i] = 1;
                    if(((j+i+1)-j)>max)
                    {
                        max = (j+i+1)-j;
                        start = j;
                        end = j+i;
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }
}

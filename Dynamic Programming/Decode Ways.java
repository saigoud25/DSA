91. Decode Ways
https://leetcode.com/problems/decode-ways/
https://youtu.be/6aEyTjOwlJU

/*
->Using Dynamic Programming
https://youtu.be/6aEyTjOwlJU

->Take 1 character or
->Take 2 characters
*/
class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        return n==0 ? 0 : helper(0, n, s);
    }
    
    int helper(int i, int n, String s)
    {
        if(i==n)
        {
            return 1;
        }
        
        if(s.charAt(i)=='0')
        {
            return 0;
        }
        
        if(dp[i] != 0) return dp[i];
        int ways = helper(i+1, n, s);
        
        if(i < n-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')))
        {
            ways += helper(i+2, n, s);
        }
        
        return dp[i] = ways;
    }
}

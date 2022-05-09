2266. Count Number of Texts
https://leetcode.com/contest/weekly-contest-292/problems/count-number-of-texts/

/*
https://youtu.be/QVf9HK3YyTE
->Using DP
*/

class Solution {
    public int countTexts(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        
        int mod = 1000000007;
        
        for(int i = 1; i<=n; i++)
        {
            char ch = s.charAt(i-1);
            
            dp[i] = dp[i-1];
            
            if(i>=2 && ch==s.charAt(i-2)) 
            {
                dp[i] = (dp[i]+dp[i-2])%mod;
            } else continue;
            
            if(i>=3 && ch==s.charAt(i-3))
            {
                dp[i] = (dp[i]+dp[i-3])%mod;
            }
            else continue;
            
            if((ch=='7' || ch=='9') && (i-4)>=0 && ch==s.charAt(i-4) ) dp[i] = (dp[i]+dp[i-4])%mod;
        }
        
        return (int)(dp[n]%mod);
    }
}

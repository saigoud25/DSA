44. Wildcard Matching
https://leetcode.com/problems/wildcard-matching/
https://youtu.be/ZmlQ3vgAOMo

/*
->Using Dynamic Programming
https://youtu.be/ZmlQ3vgAOMo

->If the s.charAt(i)==p.charAt(i) or s.charAt(i)=='?' check for func(i-1, j-1)
->If the s.charAt(i)=='*', return func(i-1, i) || func(i, j-1)
*/
class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[p.length()+1][s.length()+1];
        
        return helper(p.length()-1, s.length()-1, p, s);
    }
    boolean helper(int i, int j, String s, String p)
    {
        if(i<0 && j<0) return true;

        if(i<0 && j>=0) return false;
        
        if(j<0 && i>=0)
        {
            for(int k = 0; k<=i; k++)
            {
                if(s.charAt(k)!='*')
                {
                    return false;
                }
            }  
            return true;
        }
        
        
        if(dp[i][j] != 0)
        {
            return dp[i][j]==1 ? true : false;
        }
        
        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?')
        {
            boolean flag = helper(i-1, j-1, s, p);
            dp[i][j] = flag==true ? 1 : 2;
            return flag;
        }
        else if(s.charAt(i)=='*')
        {
            boolean flag = helper(i-1, j, s, p) || helper(i, j-1, s, p);
            dp[i][j] = flag==true ? 1 : 2;
            return flag;
        }
        
        dp[i][j] = 2;
        return false;
    }
}

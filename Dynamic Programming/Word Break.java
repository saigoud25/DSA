139. Word Break
https://leetcode.com/problems/word-break/
https://youtu.be/fNVs1J2KCyo

/*
->Using Dp
https://youtu.be/fNVs1J2KCyo

->Partion the string into two parts,
    ->First we check for whether 1st half is contains in the dictionary
    ->If yes, check second half as new String
*/
class Solution {
    HashSet<String> set;
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet(wordDict);
        dp = new int[s.length()];
        
        helper(0, s);
        
        if(dp[0]==2) return true;
        return false;
    }
    
    boolean helper(int i, String s)
    {
        if(s.equals("")) return true;
        if(i==s.length()) return true;
        if(dp[i] != 0)
        {
            if(dp[i]==2) return true;
            else return false;
        }
        for(int j = i; j<=s.length(); j++)
        {
            if(set.contains(s.substring(i, j)) && helper(j, s))
            {
                dp[i] = 2;
                return true;
            }
        }
        dp[i] = 1;
        return false;
    }
}

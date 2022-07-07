97. Interleaving String
https://leetcode.com/problems/interleaving-string/

/*
->Iterate from the backside
->If last characters of 3 Strings are equal we will have 3 options, traverse (l1-1, l3-1) && (l2-1, l3-1)
->If characters of s1 and s3 are equal, traverse (l1-1, l3-1)
->If characters of s2 and s3 are equal, traverse (l2-1, l3-1)
*/
class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        
        dp = new int[s1.length()][s2.length()];
        int ans = func(s1.length()-1, s2.length()-1, s3.length()-1, s1, s2, s3);
        return ans==1 ? true : false;
    }
    
    public int func(int l1, int l2, int l3, String s1, String s2, String s3)
    {
        if(l1<0 && l2<0 && l3<0) return 1;
        
        if(l1>=0 && l2>=0 && dp[l1][l2] != 0) return dp[l1][l2];
        
        if(l1>=0 && l2>=0 && l3>=0 && s1.charAt(l1)==s3.charAt(l3) && s2.charAt(l2)==s3.charAt(l3))
        {
            if(func(l1-1, l2, l3-1, s1, s2, s3)==1 || func(l1, l2-1, l3-1, s1, s2, s3)==1) return dp[l1][l2] = 1;
            else return dp[l1][l2] = -1;
        }
        
        if(l1>=0 && l3>=0 && s1.charAt(l1)==s3.charAt(l3))
        {
            return func(l1-1, l2, l3-1, s1, s2, s3);
        }
        
        if(l2>=0 && l3>=0 && s2.charAt(l2)==s3.charAt(l3))
        {
            return func(l1, l2-1, l3-1, s1, s2, s3);
        }
        
        return -1;
    }
}

1641. Count Sorted Vowel Strings
https://leetcode.com/problems/count-sorted-vowel-strings/

/*
->Using DP Tabular method
->Just add the adjacent elements of array
->Find the pattern where, n is 1,2,3,4,5,6 to know the solution
*/
class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        if(n==0) return n;
        Arrays.fill(dp, 1);
        
        while(n-- > 0)
        {
            int sum = 1;
            for(int i = 1; i<5; i++)
            {
                sum += dp[i];
                dp[i] = sum;
            }
        }
        
        return dp[4];
    }
}

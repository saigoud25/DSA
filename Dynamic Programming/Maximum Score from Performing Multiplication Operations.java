1770. Maximum Score from Performing Multiplication Operations
https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
https://youtu.be/Zf-ywhYkra8

/*
->Using DP
https://youtu.be/Zf-ywhYkra8

->While traversing multipliers array, we have two options
->Can choose left or right from the nums
*/
class Solution {
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new Integer[multipliers.length][multipliers.length];
        int ans = helper(0, 0, nums, multipliers);

        int max = Integer.MIN_VALUE;

        return ans;
    }
    
    public int helper(int l, int i, int[] nums, int[] multi) {
        //Base Case
        if(i==multi.length) {
            return 0;
        }
        
        if(dp[l][i] != null) {
            return dp[l][i];
        }
        
        //Taking left element
        int ans = helper(l+1, i+1, nums, multi) + nums[l]*multi[i];
        
        //Taking right element
        ans = Math.max(ans, helper(l, i+1, nums, multi) + nums[nums.length-(i-l)-1]*multi[i]);
        
        return dp[l][i] = ans;
    }
}

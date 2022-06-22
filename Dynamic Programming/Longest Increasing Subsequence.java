300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
https://youtu.be/IFfYfonAFGc

/*
->Using DP
https://youtu.be/IFfYfonAFGc

*/
class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        // dp = new int[nums.length][nums.length];
        
        //Tabulation Method
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        
        Arrays.fill(dp, 1);
        
        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
        
        // visited = new boolean[nums.length];
        // return helper(0, -1, nums);
    }
    
    //Recursion + Memoization
    int helper(int i, int prev, int[] nums)
    {
        if(i==nums.length) return 0;
        
        if(prev != -1 && dp[prev][i] != 0) return dp[prev][i];
        
        int len = helper(i+1, prev, nums);
        
        if(prev == -1 || nums[i]>nums[prev])
        {
            len = Math.max(len, 1+helper(i+1, i, nums));
        }
        
        // visited[i] = true;
        if(prev != -1) dp[prev][i] = len;
        return len;
    }
}

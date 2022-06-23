673. Number of Longest Increasing Subsequence
https://leetcode.com/problems/number-of-longest-increasing-subsequence/
https://youtu.be/cKVl1TFdNXg


/*
->Using Dp, Longest Increasing Subsequence Method
https://youtu.be/cKVl1TFdNXg

->dp to find the number of longest subsequences
->Find the maximum longest subsequence maxi
->count is to find the how many times the LIS occured at that position

*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxi = 1;
        
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        for(int i = 1; i<n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(nums[j]<nums[i] && 1+dp[j] > dp[i])
                {
                    dp[i] = 1+dp[j];
                    count[i] = count[j];
                }
                else if(nums[j]<nums[i] && 1+dp[j]==dp[i])
                {
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int nos = 0;
        for(int i =0; i<n; i++) 
        {
            if(dp[i]==maxi) nos += count[i];
        }
        return nos;
    }
}

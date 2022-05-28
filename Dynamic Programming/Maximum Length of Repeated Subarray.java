718. Maximum Length of Repeated Subarray
https://leetcode.com/problems/maximum-length-of-repeated-subarray/
https://youtu.be/_wP9mWNPL5w

/*
->Using Dynamic Programming
->The problem is same as Longest Common Substring
https://youtu.be/_wP9mWNPL5w

->If nums1[i]==nums[j] add dp[i-1][j-1]+1 to dp
*/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 1; i<=nums1.length; i++)
        {
            for(int j = 1; j<=nums2.length; j++)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                    
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}

213. House Robber II
https://leetcode.com/problems/house-robber-ii/
https://youtu.be/3WaxQMELSkw


/*
->Using DP
https://youtu.be/3WaxQMELSkw
(Check House Robber)
->func(i) = nums[i]+func(i-2) , func(n-1)

->First find max for 0 to n-1 array and next 1 to n, maximum of both will be the ans
*/

class Solution {
    //Tabular Method
    public int rob(int[] nums)
    {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)), 
                        helper(Arrays.copyOfRange(nums, 1, n)));
    }
    
    
    public int helper(int[] nums)
    {
        int[] dp = new int[nums.length];
        if(nums.length==1)
        {
            return nums[0];
        }
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i<nums.length; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length-1];
    }
}

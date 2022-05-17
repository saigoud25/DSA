198. House Robber
https://leetcode.com/problems/house-robber/
https://youtu.be/GrMBfJNk_NY


/*
->Using DP
https://youtu.be/GrMBfJNk_NY

->func(i) = nums[i]+func(i-2) , func(n-1)
*/

class Solution {
    //Tabular Method
    public int rob(int[] nums)
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
    
    Recursion+Memoization
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return func(nums, nums.length-1);
    }
    
    int func(int[] nums, int i)
    {
        if(i==0) return nums[i];
        
        if(dp[i]!=-1) return dp[i];
        
        int l1 = func(nums, i-1);
        int l2 = nums[i];
        if(i>1)
        {
            l2 = nums[i]+func(nums, i-2);
        }

        dp[i] = Math.max(l1, l2);
        return dp[i];
    }
}

377. Combination Sum IV
https://leetcode.com/problems/combination-sum-iv/


/*
https://youtu.be/GWqe_xfqxCA
*/
class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        return helper(target, nums);
    }
    
    int helper(int target, int[] nums)
    {
        if(dp[target] > -1) return dp[target];
        
        if(target == 0) return 1;
        
        int count = 0;
        for(int i : nums) {
            if(i<=target) {
                count += helper(target-i, nums);
            }
        }
        
        return dp[target] = count;
    }
}

416. Partition Equal Subset Sum
https://leetcode.com/problems/partition-equal-subset-sum/
https://youtu.be/7win3dcgo3k

/*
->Using Dynamic Programming
https://youtu.be/7win3dcgo3k

->Same as subset sum problem
->The sum of subset equals to the (totalSum/2);
->S1+S2 = totalSum
->2S = totalSum
->S1 = (totalSum)/2
->Take/Not Take method
*/

class Solution {
    int[][] arr;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum%2!=0) return false;

        arr = new int[nums.length][(sum/2)+1];

        return dp(nums.length-1, nums, (sum/2));
    }
    
    boolean dp(int i, int[] nums, int sum)
    {
        if(sum==0) return true;
        
        if(i==0)
        {
            if(sum-nums[i]==0) return true;
            return false;
        }
        if(arr[i][sum]!=0)
        {
            if(arr[i][sum]==-1) return false;
            else return true;
        }
        //NotTake
        boolean notTake = dp(i-1, nums, sum);
        
        boolean take = false;
        if(nums[i]<=sum)
        {
            take = dp(i-1, nums, sum-nums[i]);
        }
        if(take||notTake)
        {
            arr[i][sum] = 1;
        }
        else arr[i][sum] = -1;
        return take||notTake;
    }
}

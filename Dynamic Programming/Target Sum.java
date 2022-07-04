494. Target Sum
https://leetcode.com/problems/target-sum/

/*
->Using Backtracking + DP
->At each index we have two steps
    ->Adding (+), add the sum+nums[i](new sum) and call the function
    ->Subtract (-), subtract sum-nums[i] and call the function
*/
class Solution {
    HashMap<Map.Entry<Integer, Integer>, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        // dp = new int[nums.length][2*target+1];
        map = new HashMap<>();
        
        return func(0, 0, target, nums);
    }
    
    public int func(int i, int sum, int target, int[] nums)
    {
        if(i==nums.length)
        {
            if(sum==target)
            {
                return 1;
            }
            return 0;
        }
        
        Map.Entry<Integer, Integer> entry = Map.entry(i, sum);
        
        if(map.containsKey(entry)) return map.get(entry);

        int forMinus = func(i+1, sum-nums[i], target, nums);
        
        int forPlus = func(i+1, sum+nums[i], target, nums);
        
        map.put(entry, forMinus+forPlus);
        
        return forMinus+forPlus;
    }
}

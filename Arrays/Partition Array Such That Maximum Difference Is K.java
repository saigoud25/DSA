2294. Partition Array Such That Maximum Difference Is K
https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/

/*
->Sort the nums array
->Iterate through the nums array and maintain max and min values
->If max-min>k increment the count and update the max and min values
*/
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++)
        {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);

            if(max-min > k)
            {
                count++;
                max = min = nums[i];
            }

        }
        return count;
    }
}

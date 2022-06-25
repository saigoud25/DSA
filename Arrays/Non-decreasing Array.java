665. Non-decreasing Array
https://leetcode.com/problems/non-decreasing-array/

/*
https://leetcode.com/problems/non-decreasing-array/discuss/2193084/Visual-Explanation-or-JAVA-Greedy

->When we need to change the value, we would have two options, change the value based on i-2th value
->If nums[i-2]>=nums[i], change nums[i]=nums[i-1]
->If nums[i-2]<nums[i], change nums[i-1] = nums[i]
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for(int i = 1; i<nums.length && count<=1; i++)
        {
            if(nums[i-1]>nums[i])
            {
                count++;
                if(i-2<0 || nums[i-2] <= nums[i])
                {
                    nums[i-1] = nums[i];
                }
                else
                {
                    nums[i] = nums[i-1];
                }
            }
        }

        return count<=1;
    }
}

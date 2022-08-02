53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

/*
->Using Kadane's Algorithm
->Update max each time, when count becomes less than 0, update count with 0
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i : nums) {
            count += i;
            
            max = Math.max(max, count);
            
            if(count < 0) {
                count = 0;
            }
        }

        return max;
    }
}

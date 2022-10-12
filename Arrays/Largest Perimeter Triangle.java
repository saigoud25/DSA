976. Largest Perimeter Triangle
https://leetcode.com/problems/largest-perimeter-triangle/

/*
->Sort the Array
->To form a triangle, the sum of two sides must be greater than one side
->Check every 3 contiguous elements from the last, if satisfy the condition return sum of those 3 numbers
*/
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = nums.length-1; i>=2; i--) {
            if(nums[i] < nums[i-1]+nums[i-2]) {
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        
        return 0;
    }
}

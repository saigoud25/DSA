645. Set Mismatch
https://leetcode.com/problems/set-mismatch/

/*
->Using Cyclic Sort Method
->In first Iteratation, set all elements at their respective indexes
->In second Iteration, find which element is not following Cyclic sort condition and return it
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        
        while(i<nums.length) {
            if((nums[i] == i+1) || (nums[i]==nums[nums[i]-1])) {
                i++;
            } else {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        
        for(i = 0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                return new int[]{nums[i], i+1};
            }
        }
        
        //Dummy return
        return new int[]{1, 1};
    }
}

2344. Minimum Deletions to Make Array Divisible
https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/

/*
->Find the GCD (Greatest Common Devisor) of numsDivide elements
->Sort the nums Array
->Iterate through the nums array, 
    -> If GCD%nums[i] == 0, which means nums[i] will divides all the elements of numsDivide, return nums[i]
    -> Else Increment count;
*/
class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g = numsDivide[0], temp;
        int prev = -1, count = 0;
        
        for(int a : numsDivide) {
            while(a>0) {
                temp = g%a;
                g = a;
                a = temp;
            }
        }
        
        Arrays.sort(nums);
        
        for(int i : nums) {
            if(g%i == 0) return count;
            else count++;
        }
        
        return -1;
    }
}

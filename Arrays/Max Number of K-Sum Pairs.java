1679. Max Number of K-Sum Pairs
https://leetcode.com/problems/max-number-of-k-sum-pairs/


/*
Method-1
->Use HashMap and HashSet
Method-2
->Using 2Sum two pointer method
->If sum=k, increment count, start and decrement end
*/
class Solution {
    public int maxOperations(int[] nums, int k) {
        //Method-2
        Arrays.sort(nums);
        int start = 0, end = nums.length-1, count = 0;
        while(start<end)
        {
            if(nums[start]+nums[end]==k)
            {
                count++;
                start++;
                end--;
            }
            else if(nums[start]+nums[end]<k)
            {
                start++;
            }
            else
            {
                end--;
            }
        }   
        return count;
    }
}

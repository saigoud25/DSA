462. Minimum Moves to Equal Array Elements II
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

/*
->Sort the Array
->Find the mid, increment elements upto min, decrement elements upto mid
*/
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        // int mid = nums.length/2;
        int start = 0, end = nums.length-1;
        
        // for(int i : nums)
        // {
        //     count += Math.abs(i-ele);
        // }
        
        while(start<end)
        {
            count += nums[end--] - nums[start++];
        }
        
        return count;
    }
}


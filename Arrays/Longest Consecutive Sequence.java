128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/
https://youtu.be/qgizvmgeyUM

/*
->Using the HashSet, first store all the values in the set
->Traverse the for loop, if the arr[i]-1 is not contain in the list 
    ->which means arr[i] is the starting value then start anothor while loop and check the consectutive elements
    ->Maintain the count while checking, when loop ends check count with max and update max value
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int max = 0;
        
        for(int i = 0; i<nums.length; i++)
        {
            if(!set.contains(nums[i]-1))
            {
                int ele = nums[i];
                int count = 0;
                while(set.contains(ele))
                {
                    ele++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        
        return max;
    }
}

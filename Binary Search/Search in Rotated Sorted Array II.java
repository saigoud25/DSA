81. Search in Rotated Sorted Array II
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
https://youtu.be/WkihvY2rJjc

/*
https://youtu.be/WkihvY2rJjc
->If start==target==end 
    ->Increment start by 1 and Decrement end by 1
*/
class Solution {
    public boolean search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end)
        {
            int mid = start + (end-start) / 2;
            
            if(nums[mid] == target) return true;
            if(nums[start] == nums[mid] && nums[end] == nums[mid])
            {
                start++;
                end--;
            }
            else if(nums[start] <= nums[mid])
            {
                if(nums[start]<=target && nums[mid]>target)
                {
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                }
            }
            else
            {
                if(nums[mid] < target && nums[end] >= target)
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
        }
        
        return false;
    }
}

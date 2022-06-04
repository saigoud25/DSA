153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

/*
->Compare the mid element with the end element, 
->If the mid is greater than nums[end] the ans should be right side of mid, so upadate the start with mid+1
->Else ans should be right side so update the end with mid
*/

class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length -  1;
        int mid = 0;
        
        while(start <= end)
        {
            mid = start + (end-start) / 2;
            
            if(start == end)
            {
                return nums[start];
            }
            if(nums[mid] > nums[end])
            {
                start = mid + 1;
            }
            else if(nums[mid] < nums[end])
            {
                end = mid;
            } 
        }
        
        return nums[0];    
    }    
}

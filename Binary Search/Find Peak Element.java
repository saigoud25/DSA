162. Find Peak Element
https://leetcode.com/problems/find-peak-element/

/*
->If the mid is less than the mid+1, which means the mid is not a peak element, so update start with mid+1
->Else the ans should be left side of the array, update the end with the mid
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -  1;
        int mid = 0;
        
        if(end == 0) return 0;
        
        while(start<end)
        {
            mid = start + (end-start) / 2;
            
            if(nums[mid] > nums[mid+1])
            {
                end = mid;
            }
            else start = mid + 1;
            
        }
        
        return start;
    }
}

410. Split Array Largest Sum
https://leetcode.com/problems/split-array-largest-sum/
https://youtu.be/wLXMu_XJnLo
Binary Search can also applied on Unsorted Array, This kind of problems called as *Binary Search on Answers*.
  
/*
https://youtu.be/wLXMu_XJnLo
->Using Binary Search
->Take maximum element in the array as a start and sum of array as end
->Binary search through the given range
->Here we check whether the mid is possible or not
->If we can get less or equal number of subarrays we need to update the ans with mid and make end as mid-1, search for next least sum
->Else make sum as mid+1
->To check whether given mid is possible to split as subarrays, Traverse through the nums array ans increment subarray count if tempSum+i is greater than mid
*/
class Solution {
    public int splitArray(int[] nums, int m) {
        int ans = 0, max = Integer.MIN_VALUE, sum = 0;
        for(int i : nums)
        {
            max = Math.max(max, i);
            sum += i;
        }
        
        int start = max, end = sum;
        
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            
            int subArrays = isPossible(nums, mid);
            
            if(subArrays<=m)
            {
                end = mid - 1;
                ans = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        
        return ans;
    }
    public int isPossible(int[] nums, int mid)
    {
        int count = 0, tempSum = 0;
        
        for(int i : nums)
        {
            if(tempSum+i <= mid)
            {
                tempSum += i;
            }
            else
            {
                count++;
                tempSum = i;
            }
        }
        
        return ++count;
    }
}

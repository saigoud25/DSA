581. Shortest Unsorted Continuous Subarray
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
https://youtu.be/ho9x_C2akHg

/*
->Using two pointer 
->Find the low and high
    ->if the low+1 element is greater than low, increment low
    ->if the high-1 element is less than high, decrement high
->Find the min and max value between low and high indeces
->If the min is less than the low-1 value, decrement the low
->If the max is high than the high+1 value, increment the high
->Return the high-low+1
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int low = 0, n = nums.length, high = n-1;
        while(low+1<n && nums[low]<=nums[low+1])
        {
            low++;
        }
        if(low==n-1) return 0;
        while(high-1>=0 && nums[high-1]<=nums[high])
        {
            high--;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; 
        
        for(int i =low; i<=high; i++)
        {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        while(low-1>=0 && nums[low-1]>min) low--;
        
        while(high+1<=n-1 && nums[high+1]<max) high++;
        
        return high - low + 1;
        
    }
}

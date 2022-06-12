2134. Minimum Swaps to Group All 1's Together II
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/


/*
->Using Sliding Window Method
->Count the number of 1's in the array
->The window size should be the len(count)
->Find the number of zero's in each window, ans will be the window with least number of zero's
->The array will be consider as circular, so check the starting and ending of array as window
*/
class Solution {
    public int minSwaps(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int count = 0;
        for(int i : nums)
        {
            if(i==1) count++;
        }
        
        int z = 0;
        
        for(int k = 0; k<count; k++)
        {
            
            if(nums[k]==0) z++;
        }
        min = Math.min(min, z);
        for(int i = count; i<n+count; i++)
        {
            int ind = i%n;
            
            if(nums[ind]==0) z++;
        
            if(nums[i-count]==0) z--;

            min = Math.min(min, z);
        }
        
        return min;
    }
}

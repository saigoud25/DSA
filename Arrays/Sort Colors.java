75. Sort Colors
https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        int n = nums.length;
        
        //To count number of zero's, one's and two's
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == 0) zero++;
            else if(nums[i] == 1) one++;
            else two++;
        }
        
        int i = 0;
        while(zero-- > 0)
        {
            nums[i] = 0;
            i++;
        }
        while(one-- > 0)
        {
            nums[i] = 1;
            i++;
        }
        while(two-- > 0)
        {
            nums[i] = 2;
            i++;
        }
        return;
    }
}

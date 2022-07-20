2256. Minimum Average Difference
https://leetcode.com/problems/minimum-average-difference/


/*
->Maintain a PreSum, tsum
->For left lsum, add ith element while iterating
->For right rsum, subtract lsum from the lsum
->Check for edge cases
*/
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if(n==1) {   
            if(nums[0] == 0) return 0;
        }
    
        long tsum = 0, lsum = 0, min = Integer.MAX_VALUE, ind = 0, rsum = 0;
        int ans = 0;
        
        for(int i : nums) {
            tsum += i;
        }
        rsum = tsum;
        for(int i : nums) {
            lsum += i;
            rsum = tsum-lsum;
            long temp = Math.abs((lsum/(ind+1)) - (n- ind == 1 ? 0 : (rsum/(n-ind-1))));
            if(temp<min) {
                min = temp;
                ans = (int)ind;
            }
            ind++;
        }

        return ans;
    }
}

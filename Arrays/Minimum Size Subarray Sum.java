209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/

/*
->Find total sum, if total sum<k return 0
->Initialise values (all are zero's)
->start and end are pointer, temp stores temporary length of subarray, count stores minimum temp
->If sum<k, add arr[i] to sum, increment temp & end;
->If sum>=k, 
    ->subtract subarray's first element from sum
    ->store the min(temp, count) in count
    ->decrement temp & Increment start
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int temp = 0;
        int sum = 0;
        int n = nums.length-1;
        int start = 0, end = 0;
        if(Arrays.stream(nums).sum()<target) return 0;
        
        while(end<=n+1 && start <= end)
        {
            if(sum >= target)
            {
                sum = sum - nums[start];
                count = Math.min(count, temp);
                temp--;
                start++;     
            }
            else if(sum < target && end<=n) 
            {
                
                sum = sum + nums[end]; 
                end++;   
                temp++;
                
            }
            else end++;
        }
        return count;
    }
}

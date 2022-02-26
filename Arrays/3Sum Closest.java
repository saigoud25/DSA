16. 3Sum Closest
https://leetcode.com/problems/3sum-closest/

/*
->Using 3Sum Approach
->sort the array
->keeping one element as fixed, used two pointer method to other two elements
->save the minimum difference and it's sum
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = 0;
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        int inside_sum = 0;
        int sum = 0, start = 0, end = 0;
        
        for(int i = 0; i<n; i++)
        {
            sum = nums[i];
            start = i+1; end = n-1;
            while(start<end)
            {
                inside_sum = nums[start] + nums[end];
                sum += is;
                
                if(sum==target)
                {
                    return target;
                }
                if(sum < target)
                {
                    if((target-sum)<diff)
                    {
                        diff = target-sum;
                        temp = sum;
                    }
                }
                else
                {
                    if((sum-target)<diff)
                    {
                        diff = sum-target;
                        temp = sum;
                    }
                }
                if(sum<target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
                sum -= inside_sum;
            }
        }
        
        return temp;
    }
}

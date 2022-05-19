1498. Number of Subsequences That Satisfy the Given Sum Condition
https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
https://youtu.be/nxWT_mG-x54


/*
->Using 2SUM method
https://youtu.be/nxWT_mG-x54

->count will be the 2 pow end-start
->First fill the arr, which consists the power of 2
*/
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int start = 0, end = nums.length-1;
        int[] arr = new int[(end-start)+1];
        int ans = 1;
        for(int i = 1; i<=(end-start); i++)
        {
            ans = (ans*2 % 1000000007);
            arr[i] = ans;
        }
        arr[0] = 1;
        // System.out.println(Arrays.toString(arr));
        
        while(start<=end)
        {
            if(nums[start]+nums[end]<=target)
            {
                count = (count+arr[end-start])%1000000007;
                
                start++;
            }
            else end--;
        }
        return count;
    }
}

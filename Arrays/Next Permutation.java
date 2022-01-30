31. Next Permutation
https://leetcode.com/problems/next-permutation/
https://youtu.be/LuLCLgMElus

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        
        int i = nums.length-2;
        //check number(x) beside peak from right side
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i >= 0)
        {
            int j = nums.length-1;
            //to find the grater number than x from right side
            while(nums[j]<=nums[i])
            {
                j--;
            }
            //swap both numbers
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        //reverse the next elements from the i+1 position
        int n = nums.length-1; i++;
        while(i<n)
        {
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
            i++; n--;
        }
    }
}

11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/

/*
->Using two pointers
->If start is less than end, increment start
->Else increment end
->Store the maximum area
*/
class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = 0;
        while(start<end)
        {
            int temp = Math.min(height[start], height[end]) * (end-start);
            max = Math.max(temp, max);
            if(height[start]<height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return max;
    }
}

42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/

/*
->Create two arrays, one stores the left highest number, another stores the right highest number
->For ans count the Max(left, right)-hight[i];
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] temp = new int[n];
        int max = height[n-1], count = 0;
        
        for(int i = n-1; i>=0; i--)
        {
            max =  Math.max(max, height[i]);
            temp[i] = max;
        }
        max = height[0];
        
        for(int i = 0; i<n; i++)
        {
            max = Math.max(max, height[i]);
            count += Math.min(max, temp[i])-height[i];
        }
        // System.out.println(Arrays.toString(temp));
        
        return count;
    }
}

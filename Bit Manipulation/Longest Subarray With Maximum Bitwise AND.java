2419. Longest Subarray With Maximum Bitwise AND
https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

/*
->If current element is max, make len as 1
->If current element is equal to max, increment tha curr
->If current element is less than max, make cur as 0
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, len = 0, cur = 0;
        
        for(int i : nums) {
            if(i == max) {
                len = Math.max(len, ++cur);
            } 
            else if(i > max) {
                max = i;
                len = cur = 1;
            } 
            else {
                cur = 0;
            }
        }
        
        return len;
    }
}

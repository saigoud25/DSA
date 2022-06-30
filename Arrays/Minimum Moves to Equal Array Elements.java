453. Minimum Moves to Equal Array Elements
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

/*
->Instead of incrementing (n-1) elements by 1, we can decrement 1 element by 1
->So we have to decrement all numbers to the one number, which is minimum number in the array
*/
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums) min = Math.min(i, min);
        int count = 0;
        for(int i : nums)
        {
            count += (i-min);
        }
        return count;
    }
}

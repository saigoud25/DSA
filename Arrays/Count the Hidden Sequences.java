2145. Count the Hidden Sequences
https://leetcode.com/problems/count-the-hidden-sequences/
https://youtu.be/KX2K8ypzPIQ

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = 0, min = 0, temp = 0;
        for(int diff : differences)
        {
            temp += diff;
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        int a = (int)(upper-max + min-lower)+1 ;
        return a>-1?a:0;
    }
}

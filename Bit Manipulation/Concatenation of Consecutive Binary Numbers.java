1680. Concatenation of Consecutive Binary Numbers
https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/


/*
->Traverse from 1 to N
->Right Shift the answer by the length of i places and add i to the answer
*/
class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int i = 1, len = 0;
        
        while(i <= n) {
            
            if((i&(i-1)) == 0) {
                len++;
            }
            
            ans = ((ans<<len) + i) % 1000000007;
            i++;
        }
        
        return (int) ans;
    }
}

342. Power of Four
https://leetcode.com/problems/power-of-four/

/*
->https://leetcode.com/problems/power-of-four/discuss/80457/Java-1-line-(cheating-for-the-purpose-of-not-using-loops)

->First check whether N is power of 2, (n&(n-1)==0) is power of 2
->Check whether that single bit appears at odd position
*/
class Solution {
    public boolean isPowerOfFour(int n) {
        return (n>0) && ((n & (n-1)) == 0) && ((n & 0x55555555) != 0);
    }
}

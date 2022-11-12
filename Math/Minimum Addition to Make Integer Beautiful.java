2457. Minimum Addition to Make Integer Beautiful
https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/


/*
->Find the digit sum of n

->Iterate from the right
->Iterate upto the sum should less than the target
->rem is the sum of removed values from the n
->mul maintains the unit values
*/
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long temp = n;
        int sum = 0;
        //digit sum of n
        while(temp > 0) {
            long d = temp%10;
            sum += d;
            temp = temp/10;
        }
        
        if(sum <= target) {
            return 0;
        }
        
        long mul = 1l, rem = 0l;
        while(sum >= target) {
            long d = n%10;
            rem += d*mul;
            sum -= d;
            mul *= 10;
            n /= 10;
        }
        
        return mul-rem;
    }
}

29. Divide Two Integers
https://leetcode.com/problems/divide-two-integers/
https://youtu.be/m4L_5qG4vG8

/*
https://youtu.be/m4L_5qG4vG8

->Instead of Subtracting divisor with dividend until dividend-divisor>=0
->We double the divisor each time and then subtract

*/
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==1<<31 && divisor==-1) return Integer.MAX_VALUE;
        
        boolean sign = (dividend>=0 == divisor>=0) ? true : false;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int res = 0;
        
        while(dividend - divisor >= 0)
        {
            int count = 0;
            while(dividend - (divisor<<1<<count) >= 0)
            {
                count++;
            }
            
            res += 1<<count;
            
            dividend -= divisor<<count;
        }
        
        if(sign==false)
        {
            return res*-1;
        }
        
        return res;
    }
}

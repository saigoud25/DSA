50. Pow(x, n)
https://leetcode.com/problems/powx-n/
https://youtu.be/l0YC3876qxg

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long N = n;
        if(N<0) N = -1*N;
        
        while(N>0)
        {
            if(N%2==0)
            {
                x = x*x;
                N = N/2;
            }
            else
            {
                ans = ans*x;
                N = N-1;
            }
        }
        
        if(n<0) return 1.0/ans;
        return ans;
    }
}

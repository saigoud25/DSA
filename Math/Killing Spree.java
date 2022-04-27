Killing Spree 
https://practice.geeksforgeeks.org/problems/killing-spree3020/1#

/*
->Loop through the i, check whether i*i<=n 
    ->If true, substract i*i from the n
    ->Else return i-1
*/
class Solution{
    long killinSpree(long n)
    {
        long i = 1;
        for(; i*i <= n; i++)
        {
            n -= (i*i);
        }
        return i-1;
    }
}

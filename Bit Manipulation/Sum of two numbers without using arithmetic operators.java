Sum of two numbers without using arithmetic operators
https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1#

/*
->xor stores the xor values of a and b (original sum)
->carry stores the and values of and b (carry)
->If carry is 0, return xor
->Else left shift the carry by 1 and, return the same function, xor as a and carry as b
*/

class Solution
{
    int sum(int a , int b)
    {
        //code here
        int xor = a^b;
        int carry = a&b;
        if(carry==0) return xor;
        
        return sum(xor, carry<<1);
    }
}

Count the subarrays having product less than k 
https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/#
https://www.youtube.com/watch?v=NcD0CZLd6xM

Input : 
n = 4, k = 10
a[] = {1, 2, 3, 4}
Output : 
7
Explanation:
The contiguous subarrays are {1}, {2}, {3}, {4} 
{1, 2}, {1, 2, 3} and {2, 3} whose count is 7.


class Solution {
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int result = 0;
        long prod = 1;
        int start = 0;
        int end = 0;
        
        while(end<n)
        {
            prod = prod * a[end];
            
            while(start<end && prod>=k)  //if prod>=k remove a[start] from prod and increment start
            {
                prod = prod/a[start];
                start++;
            }
            
            if(prod<k)
            {
                result += (end-start) + 1; //result + length of sub array
            }
            end++;
        }
        
        return result;
    }
}

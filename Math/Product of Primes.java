Product of Primes
https://practice.geeksforgeeks.org/problems/product-of-primes5328/1#
https://youtu.be/pKvGYOnO9Ao

/*
https://youtu.be/pKvGYOnO9Ao
->Using Sieve of Eratosthenes Algorithm
->Fill array, the prime numbers are marked as the false
->Iterate from L to R, if any number is false multiply it with the ans
*/
class Solution{
    static long primeProduct(long L, long R){
        // code here
        boolean[] arr = new boolean[(int)R+1];
        long ans = 1;
        
        for(int i = 2; i*i <= R; i++)
        {
            if(arr[i] == false)
            {
                for(int j = i*i; j<=R; j += i)
                {
                    arr[j] = true;
                }
            }
        }
        
        arr[0] = true; arr[1] = true;
        for(int i = (int)L; i<=R; i++)
        {
            if(arr[i]==false)
            {
                ans = (ans*i)%1000000007;
            }
        }
        return ans;
    }
}

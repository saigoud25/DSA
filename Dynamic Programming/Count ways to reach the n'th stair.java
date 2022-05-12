Count ways to reach the n'th stair
https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1#
https://youtu.be/mLfjzJsN8us


/*
->Using DP
https://youtu.be/mLfjzJsN8us

->Fibinocci Series
*/

class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here
        if(n<3) return n;
        int ans = 0;
        int first = 1, second = 2;
        
        for(int i = 3; i<=n; i++)
        {
            ans = (first+second)%1000000007;
            first = second;
            second = ans;
        }
        
        return ans;
    }
}

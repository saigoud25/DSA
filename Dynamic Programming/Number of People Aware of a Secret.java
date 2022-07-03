2327. Number of People Aware of a Secret
https://leetcode.com/problems/number-of-people-aware-of-a-secret/
https://youtu.be/V7QVZY84KQ8

/*
https://youtu.be/V7QVZY84KQ8
->Using DP
-First find the number of active sharers in each day
->activesharers[i] = previousActiveSharers + newActiveshares - forgotters on the day

->From the ActiveSharers array add the members who knows secrete from n-forget day(remaining people forgets)
->Iterate array from (n-forget) to n-1, and add each sharers
*/
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long activeSharers = 0, mod = 1000000007;
        long[] arr = new long[n];
        arr[0] = 1;
        
        for(int i = 1; i<n; i++)
        {
            long newSharers = i-delay>=0 ? arr[i-delay]%mod : 0;
            long forgotters = i-forget>=0 ? arr[i-forget]%mod : 0;
            
            arr[i] = activeSharers + newSharers - forgotters;
            
            activeSharers = arr[i];
        }
        
        long ans = 0;
        //Remove the forgotters from the arr
        for(int i = (n-forget); i<n; i++)
        {
            ans = (ans + arr[i])%mod;
        }
        return (int)ans;
    }
}

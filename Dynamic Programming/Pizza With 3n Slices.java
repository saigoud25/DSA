1388. Pizza With 3n Slices
https://leetcode.com/problems/pizza-with-3n-slices/

/*
->Same as House Robber problem, pick k non-adjacent elements
->K is the number of slices that can be taken, N/3
->Make slices array (0 to N-1) and (1 to N) for it's circular property
->Dp (Recursion + Memoization)
->Pick and Not Pick method
*/
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        
        int ans = helper(0, Arrays.copyOfRange(slices, 0, n-1), n/3, new int[n][(n/3)+1]);

        ans = Math.max(ans, helper(0, Arrays.copyOfRange(slices, 1, n), n/3, new int[n][(n/3)+1]));
        
        return ans;
    }
    
    public int helper(int i, int[] arr, int k, int[][] dp) {
        //Base Condition
        if(k==0 || i>=arr.length) {
            return 0;
        }
        
        if(dp[i][k] != 0) {
            return dp[i][k];
        }
        
        //Pick
        int max = helper(i+2, arr, k-1, dp) + arr[i];
        
        //Not Pick
        max = Math.max(max, helper(i+1, arr, k, dp));
        
        return dp[i][k] = max;
    }
}

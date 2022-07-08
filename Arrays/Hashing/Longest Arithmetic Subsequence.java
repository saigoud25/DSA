1027. Longest Arithmetic Subsequence
https://leetcode.com/problems/longest-arithmetic-subsequence/
https://youtu.be/Y3sZ2bsresI


/*
https://youtu.be/Y3sZ2bsresI
->Create a array of HashMaps
->HashMap[i] contains the diff from 0th to ith element
->3, 6, 9, 12
{[], [3->2], [6->2, 3->2], [9->2, 6->2, 3->3]}
*/
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        dp[0] = new HashMap<>();
        int max = 2;
        for(int i = 1; i<n; i++)
        {
            dp[i] = new HashMap<>();
            for(int j = 0; j<i; j++)
            {
                int diff = nums[i]-nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                max = Math.max(max, dp[i].get(diff));
            }
        }
        return max;
    }
}

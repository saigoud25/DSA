1335. Minimum Difficulty of a Job Schedule
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

/*
https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/discuss/1946366/Java-Solution-with-question-simplification


*/
class Solution {
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        if(n<d) return -1;
        
        dp = new int[d+1][n];
        
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        
        int ans = dfs(0, d, jobDifficulty);
                
        return ans;
    }
    
    public int dfs(int i, int d, int[] jd) {
        if(d==1) {
            int max = 0;
            
            for(int k = i; k<jd.length; k++) {
                max = Math.max(max, jd[k]);
            }
            
            return max;
        }
        
        if(dp[d][i] != -1) {
            return dp[d][i];
        }
        
        int max = 0, ans = Integer.MAX_VALUE;
        
        for(int k = i; k < jd.length-d+1; k++) {
            max = Math.max(max, jd[k]);

            ans = Math.min(ans, dfs(k+1, d-1, jd)+max);
        }
        
        return dp[d][i] = ans;
    }
}

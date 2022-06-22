368. Largest Divisible Subset
https://leetcode.com/problems/largest-divisible-subset/
https://youtu.be/gDuZwBW9VvM

/*
->Using DP, Longest Increasing Subsequence method
https://youtu.be/gDuZwBW9VvM

->But the condition is nums[i]%nums[j]==0
->Find the LIS and highest index maxi, from then backtrack to find ans
*/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 1, maxi = 0;
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        
        for(int i = 1; i<n; i++)
        {
            hash[i] = i;
            for(int j = 0; j<i; j++)
            {
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1)
                {
                    dp[i] = dp[j]+1; 
                    hash[i] = j;
                }
            }
            
            if(max<dp[i])
            {
                max = dp[i];
                maxi = i;
            }
        }
        // System.out.println(max);
        // System.out.println(Arrays.toString(hash));
        ans.add(nums[maxi]);
        
        while(hash[maxi] != maxi)
        {
            maxi = hash[maxi];
            ans.add(nums[maxi]);
        }
        
        // System.out.println(ans);
        return ans;
    }
}

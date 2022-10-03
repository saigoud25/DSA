1578. Minimum Time to Make Rope Colorful
https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

/*
->Remove the all consecutive colors, except one which have minimum time
*/
class Solution {
    public int minCost(String s, int[] time) {
        int ans = 0, i = 0, n = s.length();
        
        while(i<n) {
            char ch = s.charAt(i);
            int max = time[i++];
            long sum  = max;
            while(i<n && s.charAt(i)==ch) {
                sum += time[i];
                max = Math.max(max, time[i]);
                i++;
            }
            
            ans += (int)(sum-max);
        }
        
        return ans;
    }
}

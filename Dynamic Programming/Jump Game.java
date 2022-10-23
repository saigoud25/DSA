55. Jump Game
https://leetcode.com/problems/jump-game/

/*
->Method-1 
->Iterate from the back, 
->If 0 appeared, find the whether there is an required number before it's  index

->Regular DP (Recursion + Memoization)
*/
class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        //Method-1
        int n = nums.length;
        
        if(n < 2) return true;
        
        if(nums[0]==0) return false;
        
        for(int i = n-2; i>0; i--) {
            if(nums[i] == 0) {
                int req = 2;
                
                while(req > nums[i-1]) {
                    req++;
                    i--;
                    
                    if(i==0) {
                        return false;
                    }
                }
            }
        } 
        
        
        return true;
        
//        Method-2 Recursion + Memoization(DP)
//         if(nums.length==1) return true;
        
//         dp = new int[nums.length];
        
//         boolean ans = helper(0, nums);
//         return ans;
    }
    
    public boolean helper(int i, int[] nums) {
        if(i>=nums.length-1) {
            return true;
        }
        
        if(nums[i]==0) {
            return false;
        }
        
        if(dp[i] != 0) {
            return dp[i]==2 ? true : false;
        }
        
        boolean ans = false;
        
        for(int k = i+1; k<=i+nums[i]; k++) {
            ans = helper(k, nums);
            
            if(ans) {
                break;
            }
        }
        
        dp[i] = ans ? 2 : 1;
        
        return ans;
    }
}




Jump Game
https://practice.geeksforgeeks.org/problems/jump-game/1/#

/*
->Using DP
->Create a Valid boolean Array, to know whether we can start from that position
->mark valid array true, from A[i] steps,
->If valid[N-1] is true return 1, else 0
*/

class Solution {
    static int canReach(int[] A, int N) {
        // code here
        boolean[] valid = new boolean[N];
        if(A[0]==0) return 0;
        valid[0] = true;
        
        for(int i = 0; i<N; i++)
        {
            if(A[i]!=0 && valid[i]==true)
            {
                for(int j = i+1; j<=i+A[i] && j<N; j++)
                {
                    valid[j] = true;
                }
                if(valid[N-1]==true) return 1;
            }
        }
        
        return 0;
    }
};

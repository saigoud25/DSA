Subset Sum Problem
https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#

/*
->Using Dynamic Programming
https://youtu.be/fWX9xDmIzRI

recursion, take or not take method
*/

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        // return dp(N-1, arr, sum);
        boolean[] prev = new boolean[sum+1], cur = new boolean[sum+1];
        boolean[][] dp = new boolean[N][sum+1];
        for(int i = 0; i<N; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;
        
        for(int i = 1; i<N; i++)
        {
            for(int target = 1; target<=sum; target++)
            {
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(arr[i]<=target)
                {
                    take = dp[i-1][target-arr[i]];
                }
                dp[i][target] = (take || notTake);
            }
        }
        
        return dp[N-1][sum];
    }
    
    static Boolean dp(int i, int[] arr, int sum)
    {
        if(sum==0) return true;
        if(i==0)
        {
            if(sum-arr[0]==0) return true;
            else return false;
        }
        
        Boolean flag = dp(i-1, arr, sum); //Not Taking Element
        
        if(flag==false && arr[i]<=sum)
        {
            flag = dp(i-1, arr, sum-arr[i]); //Taking Element
        }
        
        return flag;
    }
}

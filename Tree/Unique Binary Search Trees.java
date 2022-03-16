96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/
https://www.youtube.com/watch?v=CMaZ69P1bAc

/*
https://www.youtube.com/watch?v=CMaZ69P1bAc
->Find Catalan number and return 
*/
class Solution {
    public int numTrees(int n) {
        //Cn = Co.Cn-1 + C1.Cn-2
         // int ans = (2*n)!/n!(n+1)!;
        
        int arr[] = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i<=n; i++)
        {
            for(int j = 0; j<i; j++)
            {
                arr[i] += arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
  
}

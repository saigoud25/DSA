Minimum Sum of Absolute Differences of Pairs
https://practice.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1

/*
-Sort the Arrays and find difference
*/
class Solution { 
    long findMinSum(int[] A,int[] B,int N) { 
        Arrays.sort(A);
        Arrays.sort(B);
        
        long sum = 0;
        
        for(int i = 0; i<N; i++) {
            sum += (int)Math.abs(A[i]-B[i]);
        }
        
        return sum;
    }
}

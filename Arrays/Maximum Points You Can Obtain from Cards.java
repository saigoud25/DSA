1423. Maximum Points You Can Obtain from Cards
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/


/*
->Using Sliding Window + Kadane's algorithm, 
->Find the maximum sum of subarray of length k from an array
->Here array is the starting k elements + ending k elements
->We take reverse of starting k elements and reverse of ending k elements
->Eg: [1,2,3,4,5,6,1] k=3 => [3,2,1,1,6,5]
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, temp = 0;
        int n = cardPoints.length;
        for(int i = k-1; i>=0 ; i--)
        {
            sum += cardPoints[i];
        }

        temp = sum;
        int x = k-1;
        for(int i = n-1; i>=(n-k); i--)
        {
            temp += cardPoints[i] - cardPoints[x--];
            sum = Math.max(temp, sum);
        }

        
        return sum;
    }
}

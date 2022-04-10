164. Maximum Gap
https://leetcode.com/problems/maximum-gap/submissions/
https://youtu.be/21XhR6r5jU8


/*
https://youtu.be/21XhR6r5jU8
->Using Bucket sort technique
->Find the maxGap between max(BucketA)-min(BucketB)
->Here Bucket contains two values A[0] = min element, A[1] = max element
*/
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        
        int maxGap = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i : nums)
        {
            min = Math.min(i, min);
            max = Math.max(i, max);
        } 
        
        int bucketSize = (int) Math.ceil((double)(max-min)/(n-1));
        
        int[][] arr = new int[n-1][2];
        for(int i : nums)
        {
            if(i!=min && i!=max)
            {
                int ind = (i-min)/bucketSize;
                if(arr[ind][0]>i || arr[ind][0]==0)
                {
                    arr[ind][0] = i;
                }
                if(arr[ind][1]<i || arr[ind][0]==0)
                {
                    arr[ind][1] = i;
                }
            }
        }
        
        for(int i = 0; i<(n-1); i++)
        {
            if(arr[i][0]==0) continue;
            maxGap = Math.max(arr[i][0]-min, maxGap);
            min = arr[i][1];
        }
        
        maxGap = Math.max(maxGap, max-min);
        return maxGap;
    }
}

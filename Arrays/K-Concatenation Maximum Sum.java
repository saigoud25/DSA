1191. K-Concatenation Maximum Sum
https://leetcode.com/problems/k-concatenation-maximum-sum/
https://youtu.be/qnoOu5Usb4o

/*
->Using Kadane's Algorithm
https://youtu.be/qnoOu5Usb4o

->If k==1, simply perform kadane's algorithm
->If total array sum is greater less than 0, the ans should between 2 contiguous arrays max sum
->If total array sum is less than 0, the ans is (twoKadane)+(k-2)*sum
*/
class Solution {
    int mod = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        for(int i : arr) sum += i%mod;
        
        if(k==1) return ((int)kadane(arr)%mod);
        else if(sum<0)
        {
            int ans = (int)(twoKadane(arr))%mod;
            
            if(ans<0) return 0;
            else return ans;
        }
        
        int x = 0;
        for(int i = 1; i<=(k-2); i++)
        {
            x = (int)((x+sum)%mod);
        }
        
        return (int)((twoKadane(arr)+x)%mod);
    }
    int twoKadane(int[] arr)
    {
        int n = arr.length;
        int[] temp = new int[n*2];
        
        for(int i = 0; i<n*2; i++)
        {
            temp[i] = arr[i%n];
        }
        
        return (kadane(temp)%mod);
    }
    int kadane(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i : arr)
        {
            curSum = (curSum+i);
            
            max = Math.max(max, curSum);
            
            if(curSum<0)
            {
                curSum = 0;
            }
        }
        if(max<0) return 0;
        return max;
    }
}

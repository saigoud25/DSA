1094. Car Pooling
https://leetcode.com/problems/car-pooling/

/*
->Using Prefix Sum Method (same as Array Manipulation Hackerrank)
->Create an Extra Array to store the prefix sum of passengers
->Iterate through the trips
    ->Add numPassengers at "from" position(arr[i[1]]) to array
    ->Remove numPassengers at "to" position(arr[i[2]]) to the array
->Make prefix sum of array, if any posiotion value exceeds capacity return false
*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        int last = Integer.MIN_VALUE;
        for(int[] i : trips)
        {
            int mem = i[0];
            int start = i[1], end = i[2];
            arr[start] += mem;
            arr[end] -= mem;
            last = Math.max(end+1, last);
        }

        if(arr[0]>capacity) 
        {
            return false;
        }
        for(int i = 1; i<last; i++)
        {
            arr[i] += arr[i-1];
            if(arr[i]>capacity) 
            {
                return false;
            }
        }
        
        return true;   
     }
}

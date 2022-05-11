Minimize the Heights II
https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
https://youtu.be/Av7vSnPSCtw

/*
https://youtu.be/Av7vSnPSCtw
->Sort the array
->Increment i by k and decrement i+1 by k, and compare with the smallest and largest
->store the min of ans and (max-min)
*/
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        
        int ans = arr[n-1]-arr[0];
        int smallest = arr[0]+k;
        int largest = arr[n-1]-k;
        
        int min = 0, max = 0;
        
        for(int i = 0; i<n-1; i++)
        {
            min = Math.min(smallest, arr[i+1]-k);
            max = Math.max(largest, arr[i]+k);
            if(min<0) continue;
            ans = Math.min(ans, max-min);
        }
        
        return ans;
    }
}

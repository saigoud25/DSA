Subarray with given sum
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/


/*
->Using sliding window method
->If the sum is less than the target, add the arr[i] to sum
->If sum is greater than the target, remove elements from back(start) until it is less than target
*/

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int start = 0, end = 0, sum = 0;
        
        for(int i = 0; i<n; i++)
        {
            if(sum==s) 
            {
                return new ArrayList<Integer>(Arrays.asList(start+1, end));
            }
            sum += arr[i];
            end++;
            while(sum>s)
            {
                sum -= arr[start++];
            }
        }
        if(sum==s) 
        {
            return new ArrayList<Integer>(Arrays.asList(start+1, end));
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
}

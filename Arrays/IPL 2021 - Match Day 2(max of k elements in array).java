IPL 2021 - Match Day 2
(Need to find the max of each contiguous sub_array of length k)
https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/#

/*
->Using Sliding Window Technic
->First find the max of first k elements
->Then iterate from k, add next element to window and remove first element from window
->If the remove element is max, find the new max in the remaing window
->Add the max to the result array everytime
*/

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<k; i++)
        {
            max = Math.max(max, arr[i]);
        }
        res.add(max);
        for(int i = k; i<n; i++)
        {
            int remove = arr[i-k];
            int add = arr[i];
            
            if(remove==max)
            {
                max = Integer.MIN_VALUE;
                for(int j = (i-k+1); j<i; j++)
                {
                    max = Math.max(max, arr[j]);
                }
            }
            max = Math.max(max, add);
            res.add(max);
        }
        
        return res;
    }
}

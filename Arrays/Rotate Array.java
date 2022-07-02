189. Rotate Array
https://leetcode.com/problems/rotate-array/


/*
->Method 1
->Reverse the total Arrays -> [7,6,5,4,3,2,1]
->Reverse starting to k-1 --> [5,6,7,4,3,2,1]
->Reverse from k to end ----> [5,6,7,1,2,3,4]
*/
class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;
        //Method-1
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        
        //Method-2 Using Extra space
        
        // int[] temp = new int[n];
        // for(int i = 0; i<n; i++)
        // {
        //     // System.out.println(i%n);
        //     temp[i] = nums[i];
        // }
        // for(int i = 0; i<n; i++)
        // {
        //     nums[(i+k)%n] = temp[i];
        // }
        return;
    }
    void reverse(int[] nums, int s, int e)
    {
        while(s<e)
        {
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }
}

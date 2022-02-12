287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/

/*
->Using Cyclic Sort
*/
class Solution {
    public int findDuplicate(int[] arr) {
        int i = 0, n = arr.length;
        int temp = 0, ele = 0;
        
        //This is using Cyclic sort ->  O(n)
        //We can do this using Maps 
        while(i<arr.length)
        {
            ele = arr[i];

            if(ele == i+1) i++;
            else
            {
              if(ele == arr[ele-1]) i++;
              else
              {
                  temp = arr[i];
                  arr[i] = arr[ele-1];
                  arr[ele-1] = temp;
              }
            }
        }
            
        i = 0;
        while(i<n)
        {
            if(arr[i] != i+1) return arr[i];
            i++;
        }
        return 0;
    }
}

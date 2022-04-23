Search insert position of K in a sorted array
https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1#

*
->Perform Binary Search on Array
->If find the Kth element return the mid position
->Else Return the start position
*/
class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        // code here
        int start =0, end = N-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(Arr[mid] == k) return mid;
            else if(Arr[mid]>k)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return start;
    }
}

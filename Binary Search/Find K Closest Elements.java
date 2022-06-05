658. Find K Closest Elements
https://leetcode.com/problems/find-k-closest-elements/
https://youtu.be/o-YDQzHoaKM

/*
->Using Binary Search Algorithm to find the size of the ans window
https://youtu.be/o-YDQzHoaKM

->Search for perfect window size in the sorted array,
->Once find the starting position of the window size k, add start+k element in the new list and return
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0, end = arr.length-k;
        
        while(start<end)
        {
            int mid = start + (end-start)/2;
            
            if(x-arr[mid] > arr[mid+k]-x)
            {
                 start = mid+1;
            }
            else
            {
                end = mid;
            }
        }
        
        for(int i = start; i<start+k; i++)
        {
            list.add(arr[i]);
        }
        
        return list;
    }
}

Find Transition Point
https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1/


/*
->Binary Search on the array
->If found 1, store the mid in the point variable and make end as mid-1, search for left side
->Else make start as the mid+1
*/
class GfG {
    int transitionPoint(int arr[], int n) {
        // code here
        int start = 0, end = n-1;
        int point = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            
            if(arr[mid]==1)
            {
                point = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
            
        }
        
        return point;
    }
}

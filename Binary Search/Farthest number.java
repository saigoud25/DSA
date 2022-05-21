Farthest number
https://practice.geeksforgeeks.org/problems/1a31d09f7b8e9c0633339df07858deb3a728fe19/1#
https://youtu.be/lZ1fEHg5foM

/*
->Using Binary Search Algorithm
https://youtu.be/lZ1fEHg5foM

->First create a temp array, to search minimum farthest element
->3 1 5 2 4 (given array)
->1 1 2 2 4 (temp array)
->for the Arr[i], search in i+1 to N-1, elements 
*/

class Solution 
{ 
    static int[] farNumber(int N, int Arr[])
	{    
	    int[] temp = new int[N];
	    temp[N-1] = Arr[N-1];
	    for(int i = N-2; i>=0; i--)
	    {
	        temp[i] = Math.min(Arr[i], temp[i+1]);
	    }
	    
	    for(int i = 0; i<N-1; i++)
	    {
	        
	        int start = i+1, end = N-1;
	        int t = -1, target = Arr[i];
	        while(start<=end)
	        {
	            int mid = start + (end-start)/2;
	            
	            if(temp[mid]<target)
	            {
	                
	                t = mid;
	                start = mid+1;
	            }
	            else
	            {
	                end = mid-1;
	            }
	        }
	        temp[i] = t;
	    }
        temp[N-1] = -1;
        return temp;
	}
}

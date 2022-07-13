Leaders in an array
https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/


/*
->Traverse from back side, maintain the top variable which stores the max value
->If the arr[i] is greater than or equal to top, add the arr[i] into the result array and make top = arr[i]
*/
class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        int top = 0;
        for(int i = n-1; i>=0; i--)
        {
            if(arr[i] >= top)
            {
                top = arr[i];
                result.add(top);
            }
        }
        Collections.reverse(result);
        return result;
    }
}

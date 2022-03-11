Height Using Parent Array
https://practice.geeksforgeeks.org/problems/height-using-parent-array4103/1#

/*
->First find the root element(-1) and store the index
->Every time traverse from start and check for new root
    ->If new root found, update new root with new index, increment height
*/
class Solution{
    static int findHeight(int N, int arr[]){
        // code here
        int height = 1;
        int root = 0;
        for(int i = 0; i<N; i++)
        {
            if(arr[i] == -1)
            {
                root = i;
                break;
            }
        }
        for(int i = 0; i<N; i++)
        {
            if(arr[i] == root)
            {
                root = i;
                height++;
                i = -1;
            }
        }
        return height;
    }
}

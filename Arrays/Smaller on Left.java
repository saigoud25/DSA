Smaller on Left
https://practice.geeksforgeeks.org/problems/smaller-on-left20360700/1#

/*
->Use TreeSet lower() function to get the Greatest Minimum element
->lower(10) functions returns minimum greatest element, if not found returns null 
*/
class Complete{
    // Function for finding maximum and value pair
    public static int[] Smallestonleft (int arr[], int n) {
        // Complete the function
        int[] ret = new int[n];
        TreeSet<Integer> set = new TreeSet();
        for(int i = 0; i<n; i++)
        {
            Integer ele = set.lower(arr[i]);
            if(ele==null)
            {
                ret[i] = -1;
            }
            else
            {
                ret[i] = ele;
            }
            set.add(arr[i]);
        }
        
        return ret;
    }
}

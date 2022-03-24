Smallest greater elements in whole array
https://practice.geeksforgeeks.org/problems/smallest-greater-elements-in-whole-array2751/1#

/*
->Using TreeSet higher() function
->set.higher(arr[i]) returns the Smallest Greatest Element
->If not found it returns null
*/
class Complete{
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        // Complete the function
        TreeSet<Integer> set = new TreeSet<>();
        for(int i : arr) set.add(i);
        int[] ans = new int[n];
        
        for(int i = 0; i<n; i++)
        {
            Integer ele = set.higher(arr[i]);
            if(ele==null)
            {
                ans[i] = -10000000;
            }
            else
            {
                ans[i] = ele;
            }
        }
        
        return ans;
    }
}

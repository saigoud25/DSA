1337. The K Weakest Rows in a Matrix
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/


/*
->Store the count and index values in a TreeMap
->To count the number of 1's used the BinarySearch Algorithm
map = {1=[2], 2=[0, 3], 4=[1], 5=[4]}
->Traverse through map values upto k times
*/
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[] arr = new int[k];
        int pos = 0;
        for(int i = 0; i<mat.length; i++)
        {
            int count = search(mat[i]);

            if(!map.containsKey(count))
            {
                map.put(count, new ArrayList());
            }
        }
        // System.out.println(map);
        for(ArrayList<Integer> i : map.values())
        {
            for(int j : i)
            {
                arr[pos++] = j;
                if(pos==k) return arr;
            }
        }
        
        return arr;
    }
    
    int search(int[] arr)
    {
        int start = 0, end = arr.length-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==0)
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


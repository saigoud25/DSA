2374. Node With Highest Edge Score
https://leetcode.com/problems/node-with-highest-edge-score/

/*
->Create a new Array and update it with actual sum of a node 
->Update the ind and max accordingly
*/
class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] arr = new long[n];
        int ind = 0;
        long max = 0;
        
        for(int i = 0; i<n; i++) {
            arr[edges[i]] += i;
            if(arr[edges[i]]>max || (arr[edges[i]])==max && edges[i]<ind) {
                ind = edges[i];
                max = arr[edges[i]];
            }
        }

        return ind;
    }
}

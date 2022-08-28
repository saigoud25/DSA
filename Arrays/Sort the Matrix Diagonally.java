/*
->Using HashMap, PriorityQueue(for automatic sorting diagonal)
->the differences of same diagonal is same based on this
->we store the diagonal elements, difference as the key and diagonal values as the value.
->Update the mat array with the new values

->There is another approach, by simply collecting all diagonal elements and sorting them and updating, see 1st submission
*/
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                map.putIfAbsent(i-j, new PriorityQueue<Integer>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }
        
        return mat;
    }
}

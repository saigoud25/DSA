2352. Equal Row and Column Pairs
https://leetcode.com/problems/equal-row-and-column-pairs/


/*
->Don't check column/row wise, must check row and column
->Create the HashMap to store the row as a String in first iteration, it's frequency as the value
->Now iterate the matrix column wise and check whether column string is present in the HashMap, If yes add the frequency of string to the count
*/
class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map1 = new HashMap();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int[] i : grid) {
            for(int j : i) {
                sb.append((j+" "));
            }
            map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0)+1);
            sb.setLength(0);
        }

        for(int i = 0; i<grid[0].length; i++) {
            for(int j = 0; j<grid.length; j++) {
                int k = grid[j][i];
                sb.append((k+" "));
            }
            String s = sb.toString();
            count += map1.getOrDefault(s, 0);
            sb.setLength(0);
        }

        return count;
    }
}

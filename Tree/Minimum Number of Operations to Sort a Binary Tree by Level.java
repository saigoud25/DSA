2471. Minimum Number of Operations to Sort a Binary Tree by Level
https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/


/*
->Create a HashMap's and traverse Level Order Traversal store each level elements
->map contains, level as key and ArrayList (non-sorted) as value
->sort contains, level as key and PriorityQueue (sorted) as value
->Now traverse through each level and count the minimum number of operations to sort array
->To find minimum number of operations, 
    ->Store the original values in a HashMap, element as a key and index as a value
    ->compare original value and required value,
    ->update original value with required value and HashMap value
*/
class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    HashMap<Integer, PriorityQueue<Integer>> sort;
    int max = 0;
    public int minimumOperations(TreeNode root) {
        map = new HashMap<>();
        sort = new HashMap<>();
        helper(root, 0);
        
        int count = 0;
        
        
        for(int i = 0; i<=max; i++) {
            ArrayList<Integer> temp = new ArrayList<>(sort.get(i));

            HashMap<Integer, Integer> ind = new HashMap<>();
            for(int j = 0; j<temp.size(); j++) {
                ind.put(map.get(i).get(j), j);
            }
            
            for(int j = 0; j<temp.size(); j++) {
                int req = sort.get(i).poll();
                int curr = map.get(i).get(j);
                
                if(curr != req) {
                    count++;
                    map.get(i).set(ind.get(req), curr);
                    
                    ind.put(curr, ind.get(req));
                    
                }
            }
        }
        
        return count;
    }
    
    public void helper(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        
        map.putIfAbsent(level, new ArrayList<Integer>());
        sort.putIfAbsent(level, new PriorityQueue<Integer>());
        max = Math.max(max, level);
        
        map.get(level).add(node.val);
        sort.get(level).add(node.val);
        
        helper(node.left, level+1);
        helper(node.right, level+1);
    }
}

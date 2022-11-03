2458. Height of Binary Tree After Subtree Removal Queries
https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/

/*
->Find the Max 2 Heights from each Level
https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/discuss/2757998/find-2-maximum-of-each-level

->Max 2 Height can be find using PriorityQueue of length 2 and level as a key

*/
class Solution {
    HashMap<Integer, PriorityQueue<Integer>> level;
    HashMap<Integer, Integer> nodeLevel;
    HashMap<Integer, Integer> height;
    public int[] treeQueries(TreeNode root, int[] queries) {
        level = new HashMap<>();
        nodeLevel = new HashMap<>();
        height = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        findLevel(root, 0);
        int rh = height.get(root.val);
        
        for(int i = 0; i<n; i++) {
            int q = queries[i];
            int qLevel = nodeLevel.get(q);
            int a = -1, b = -1;
            int ans = qLevel-1;

            //If that level has more than 1, there is a chance that q has the max height so take another height and add to the qLevel 
            if(level.get(qLevel).size() == 2) {
                a = level.get(qLevel).poll();
                b = level.get(qLevel).poll();
                
                if(height.get(q) == b) {
                    ans = a+qLevel;
                } else {
                    ans = b+qLevel;
                }
                
                level.get(qLevel).add(a);
                level.get(qLevel).add(b);
            }
            
            res[i] = ans;
        }
        
        return res;
    }
    
    public int findLevel(TreeNode node, int l) {
        if(node == null) {
            return 0;
        }
        
        level.putIfAbsent(l, new PriorityQueue<Integer>());
        
        nodeLevel.put(node.val, l);
        
        int max = 0;
        max = Math.max(max, findLevel(node.left, l+1));
        max = Math.max(max, findLevel(node.right, l+1));
        height.put(node.val, max);
        
        level.get(l).add(max);
        if(level.get(l).size()>2) {
            level.get(l).poll();
        }
        
        return max+1;
    }
}

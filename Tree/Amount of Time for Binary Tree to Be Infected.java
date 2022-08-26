2385. Amount of Time for Binary Tree to Be Infected
https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

/*
->Using BFS
->Find the Children and Parent of each node and store them in HashMaps
->Traverse from the start node and increase the level, find the max level
*/
class Solution {
    
    class Pair {
        int node;
        int level;
        
        Pair(int node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    HashMap<Integer, Integer> parent;
    HashMap<Integer, ArrayList<TreeNode>> child;
    public int amountOfTime(TreeNode root, int start) {
        parent = new HashMap<>();
        child = new HashMap<>();
        helper(root, null);
        int max = 0;
        Deque<Pair> dq = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        dq.add(new Pair(start, 0));
        
        while(!dq.isEmpty()) {
            Pair p = dq.poll();
            int curr = p.node;
            int level = p.level;
            max = Math.max(level, max);
            visited.add(curr);

            for(TreeNode node : child.get(curr)) {
                if(!visited.contains(node.val)) 
                {
                    dq.add(new Pair(node.val, level+1));
                }
            }
            
            Integer itsp = parent.get(curr);
            if(itsp != null && !visited.contains(itsp)) {
                dq.add(new Pair(itsp, level+1));
            }
        }
        
        return max;
    }
    
    public void helper(TreeNode node, TreeNode par) {
        if(par!=null) {
            parent.put(node.val, par.val);
        }
        
        child.put(node.val, new ArrayList<TreeNode>());
        
        if(node.left != null) {
            child.get(node.val).add(node.left);
            helper(node.left, node);
        }
        
        if(node.right != null) {
            child.get(node.val).add(node.right);
            helper(node.right, node);
        }
        return;
    }
}

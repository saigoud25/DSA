637. Average of Levels in Binary Tree
https://leetcode.com/problems/average-of-levels-in-binary-tree/

/*
->BFS/DFS
->Using the BFS calculate the sum and count of elements in each level and add the average in the list
*/
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list =  new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        
        while(!dq.isEmpty()) {
            long sum = 0, count = dq.size();            
            for(int i = 0; i<count; i++) {
                TreeNode node = dq.poll();
                sum += node.val;
                
                if(node.left != null) {
                    dq.add(node.left);
                }
                
                if(node.right != null) {
                    dq.add(node.right);
                }
            }
            
            list.add((sum*1.0)/count);
        }

        return list;
    }
}

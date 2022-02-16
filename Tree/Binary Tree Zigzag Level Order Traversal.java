103. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


/*
->Use LevelOrderTraversal(102. Binary Tree Level Order Traversal)
->While traversing count the level,
    ->If the level is Even we have to print left to right, So add array as it is
    ->If the level is Odd we have to print right to left, So reverse the array before adding to main arr
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        if(root == null) return arr;
        int level = 0;
        dq.add(root);
        while(!dq.isEmpty())
        {
            ArrayList<Integer> subList = new ArrayList<>();
            int n = dq.size();
            
            for(int i = 0; i<n; i++)
            {
                TreeNode node = dq.poll();
                if(node.left!=null)
                {
                    dq.add(node.left);
                }
                if(node.right!=null)
                {
                    dq.add(node.right);
                }
                subList.add(node.val);
            }
            if(level%2==0)
            {
                arr.add(subList);
            }
            else
            {
                Collections.reverse(subList);
                arr.add(subList);
            }
            level++;
        }
        
        return arr;
    }
}

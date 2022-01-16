Tree: Level Order Traversal
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
//just prints 

public static void levelOrder(Node root) {
        Queue<Node> dq = new LinkedList<>();
        dq.add(root);
        
        while(!dq.isEmpty())
        {
            Node current = dq.poll();
            System.out.print(current.data+" ");
            
            if(current.left != null)
            {
                dq.add(current.left);
            }
            
            if(current.right != null)
            {
                dq.add(current.right);
            }
        }
      
}


102. Binary Tree Level Order Traversal
https://leetcode.com/problems/binary-tree-level-order-traversal/
//retruns 2D ArrayList

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        if(root == null) return arr;
        
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
            arr.add(subList);
        }
        
        return arr;
    }
}

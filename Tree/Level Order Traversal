Tree: Level Order Traversal
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

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

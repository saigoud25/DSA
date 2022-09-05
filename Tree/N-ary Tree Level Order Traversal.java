429. N-ary Tree Level Order Traversal
https://leetcode.com/problems/n-ary-tree-level-order-traversal/

/*
->Same as Level Order Traversing in a Normal Tree, but instead of adding only left & right nodes
->Add the all Children nodes to the Deque, 
->Create the output list while traversing only
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Deque<Node> dq = new ArrayDeque<>();        
        dq.add(root);
        
        while(!dq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = dq.size();
            
            for(int i = 0; i<n; i++) {
                Node node = dq.poll();
                dq.addAll(node.children);
                temp.add(node.val);
            }
            
            list.add(temp);
        }

        return list;
    }
}

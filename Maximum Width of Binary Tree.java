662. Maximum Width of Binary Tree
https://leetcode.com/problems/maximum-width-of-binary-tree/
https://youtu.be/Y2CKCnQfHJQ


/*
https://youtu.be/Y2CKCnQfHJQ
->Level Order Traverse, Store the Node and ind as a pair
->ans = lastnode.ind - firstnode.ind + 1
->Left ind = 2*ind+1
->Right ind = 2*ind+2
*/

class Pair {
    TreeNode node;
    long ind;
    Pair(TreeNode node, long ind) {
        this.node = node;
        this.ind = ind;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        
        while(!q.isEmpty()) {
            int n = q.size();
            long start = q.peekFirst().ind;
            long end = q.peekLast().ind;
            ans = (int)Math.max(ans, (end-start+1));
            
            for(int i = 0; i<n; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                long ind = p.ind;
                if(node.left != null) q.add(new Pair(node.left, (2*ind+1)));
                if(node.right != null) q.add(new Pair(node.right, (2*ind+2)));
            }
        }
        
        return ans;
    }
}

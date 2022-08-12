235. Lowest Common Ancestor of a Binary Search Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/*
->P & Q are always present in the Tree
->If the root node is greater than p and q, it means the Ancestor node may present left side, make root.left as root
->If the root node is lesser than p and q, it means the Ancestor node may present right side, make root.right as root
->If the p is less than root and q is greater than root, it means it is the common node between then return it
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val<root.val && q.val<root.val) {
                root = root.left;
            }
            else if(p.val>root.val && q.val>root.val) {
                root = root.right;
            }
            else {
                break;
            }
        }
        
        return root;
    }
}

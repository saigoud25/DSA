114. Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

/*
1.Preoder(l-R-r) traverse the tree and store them in a array
2.iterate throgh the arays and make root.right=array(i), root.null=null, update root=root.right
*/
class Solution {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList();
        arr = helper(root, arr);
        for(int i = 1; i<arr.size(); i++)
        {
            root.right = arr.get(i);
            root.left = null;
            root = root.right;
        }
    }
    public ArrayList<TreeNode> helper(TreeNode root, ArrayList<TreeNode> st)
    {
        if(root == null) return st;
        st.add(root);
        st = helper(root.left, st);
        st = helper(root.right, st);
        return st;
    }
}

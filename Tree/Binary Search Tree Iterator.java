173. Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/

/*
Traverse BST InOrder(reverse-Right-Root-Left), Store them in Stack
->For next() pop the element from stack and return it
->for hasNext(), if stack is empty return false, else return true
*/
class BSTIterator {
    Stack<Integer> st;
    public BSTIterator(TreeNode root) {
        st = new Stack();
        st = helper(root, st);
    }
    
    public int next() {
        return st.pop();
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    public Stack<Integer> helper(TreeNode root, Stack<Integer> st)
    {
        if(root == null) return st;
        st = helper(root.right, st);
        st.add(root.val);
        st = helper(root.left, st);
        return st;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

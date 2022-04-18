/*230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Method-1
->Create a ArrayList, store the traversed elements.
->Inorder Traverse the Tree.
->While traversing if ArrayList size exceeds the k, return the array
->The last element of the List will be the answer

Method-2
->Inorder Traverse the Tree.
->While Traversing increment the i, i denotes the traversed tree length
->If i==k, return the current node
->If the function returns non null value then skip the right traversal
*/
class Solution {
    int i = 0, ele = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        ele = helper2(root, k).val;
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr = helper(root, arr, k);
        // int ele = arr.get(k-1);
        // return ele;
        
        return ele;
    }
    
    public TreeNode helper2(TreeNode root, int k)
    {
        
        if(root == null) return null;
        
        TreeNode node = helper2(root.left, k);
        
        i += 1;
        
        if(i == k)
        {
            return root;
        }
        
        if(node == null)
        {
            node = helper2(root.right, k);
        }

        return node;
    }
    
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> arr, int k)
    {
        if(root == null || arr.size()>k) return arr;
        
        arr = helper(root.left, arr, k);
        arr.add(root.val);
        k++;
        arr = helper(root.right, arr, k);
        
        return arr;
    }
}

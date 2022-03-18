Array to BST
https://practice.geeksforgeeks.org/problems/array-to-bst4443/1#

/*
->Create a Binary Tree using given array
->Preorder Traverse the Tree and return arr
*/
class Tree
{
    int val;
    Tree left;
    Tree right;
    Tree(){}
    Tree(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        if(nums.length<=2) return nums;
        Tree node = new Tree();
        node = createTree(nums, 0, nums.length-1);
        ArrayList<Integer> arr = new ArrayList<>();
        arr = inorder(node, arr);
        int[] arr2 = new int[arr.size()];
        int n = arr.size()-1;
        for(int i = 0; i<=n; i++)
        {
            arr2[i] = arr.get(n-i);
        }
        return arr2;
    }
    
    ArrayList<Integer> inorder(Tree node, ArrayList<Integer> arr)
    {
        if(node==null) return arr;
        
        arr = inorder(node.left, arr);
        
        arr = inorder(node.right, arr);
        arr.add(node.val);
        return arr;
    }
    
    Tree createTree(int[] nums, int start, int end)
    {
        if(start>end) return null;
        
        int mid = (start+end)/2;
        
        Tree node = new Tree(nums[mid]);
        
        node.right = createTree(nums, start, mid-1);
        node.left = createTree(nums, mid+1, end);
        
        return node;
    }
}

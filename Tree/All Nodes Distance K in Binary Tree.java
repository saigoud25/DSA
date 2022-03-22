863. All Nodes Distance K in Binary Tree
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
https://youtu.be/B89In5BctFA

/*
1.find the nodes from target node to root, store them in a list set1
    from given example set1 = [5,3], using helper function.
2.convert the set1(ArrayList) to set(HashSet) for searching nodes becomes O(1)
3.Now find the i down nodes for each elements in the Set1 , i.e for 3 node 1down nodes are [5, 1]
    -> while i nodes are (k-position of each node)
    -> for 5th node find (2-0)=2, printKDown(5, 2) 2 down nodes
    -> for 3rd node find (2-1)=1, printKDown(3, 1) 1 down nodes
    -> make sure while for finding i down nodes, skip the taversing node.left/node.right
        if node.left/node.right is in Set
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> set1 = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        
        helper(root, target, set1);
        Set<TreeNode> set = new HashSet<TreeNode>(set1);
        for(int i = 0; i<set1.size(); i++)
        {
            TreeNode t = set1.get(i);
            printKDown(t, k-i, temp, set);
        }
        
        return temp;
    }
    void printKDown(TreeNode root, int k, ArrayList<Integer> temp, Set<TreeNode> set)
    {
        if(root==null) return;
        if(k==0)
        {
            temp.add(root.val);
            return;
        }
        if(!set.contains(root.left)) printKDown(root.left, k-1, temp, set);
        if(!set.contains(root.right)) printKDown(root.right, k-1, temp, set);
        return;
    }
    boolean helper(TreeNode root, TreeNode target, ArrayList<TreeNode> set1)
    {
        if(root==null) return false;
        if(root==target)
        {
            set1.add(root);
            return true;
        }
        boolean flag = helper(root.left, target, set1);
        if(flag == true)
        {
            set1.add(root);
            return true;
        }
        flag = helper(root.right, target, set1);
        if(flag == true)
        {
            set1.add(root);
            return true;
        }
        return false;
    }
}

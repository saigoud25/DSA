872. Leaf-Similar Trees
https://leetcode.com/problems/leaf-similar-trees/

/*
->Simply traverse through the both trees and store the leaf elements in seperated arrays
->Check whether both arrays are equal or not
*/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        
        helper(root1, set1);
        helper(root2, set2);
        
//         if(set1.size() != set2.size()) return false;
        
//         for(int i = 0; i<set1.size(); i++)
//         {
//             if(set1.get(i) != set2.get(i)) return false;
//         }
        
//         return true;
        
        return set1.equals(set2);
    }
    public void helper(TreeNode root, ArrayList<Integer> set)
    {
        if(root == null) return;
        if(root.left==null && root.right==null)
        {
            set.add(root.val);
            return;
        }
        
        helper(root.left, set);
        helper(root.right, set);
        
        return;
    }
}

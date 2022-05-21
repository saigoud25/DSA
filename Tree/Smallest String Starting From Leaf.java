988. Smallest String Starting From Leaf
https://leetcode.com/problems/smallest-string-starting-from-leaf/


/*
->Traverse the Tree, While Traversing add each character to the String
->When the left and right is null, compare the s with the ans string
->If the ans string is greater than s, replace the ans with the s
*/

class Solution {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        
        return ans;
    }
    
    void helper(TreeNode root, String s)
    {
        if(root==null)
        {
            return;
        }
        char ch = (char)(97+root.val);
        
        s = ch+s;

        if(root.left==null && root.right==null) 
        {
            if(ans.compareTo(s)>0)
            {
                ans = s;
            }
            
            return;
        }
        
        helper(root.left, s);
        helper(root.right, s);
        
        return;
    }
}

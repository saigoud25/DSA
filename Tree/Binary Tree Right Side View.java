199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/

/*
Level order Traverse using hashmap
->Put level as key and node.val
->travere left first, if right node present, then HashMap value for key level will be updated with recent node.val
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList();
        HashMap<Integer, Integer> hm = new HashMap();
        levelTraverse(root, hm, 1);
        for(int i = 1; i<=hm.size(); i++)
        {
            ret.add(hm.getOrDefault(i, 0));
        }
        return ret;
    }
    void levelTraverse(TreeNode root, HashMap<Integer, Integer> hm, int k)
    {
        if(root==null) return;
        hm.put(k, root.val);
        levelTraverse(root.left, hm, k+1);
        levelTraverse(root.right, hm, k+1);
    }
}

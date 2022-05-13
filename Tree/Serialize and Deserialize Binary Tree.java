297. Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
https://youtu.be/-YbXySKJsX8


/*
https://youtu.be/-YbXySKJsX8
->In serialize() convert the node into String using Level Order Traversal/Inorder
->In deserialize() convert the String into the Tree
*/

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        if(root==null) return "";
        dq.add(root);
        sb.append(root.val+" ");
        while(!dq.isEmpty())
        {
            TreeNode node = dq.poll();
            if(node.left==null)
            {
                sb.append("n ");
            }
            else
            {
                sb.append(node.left.val+" ");
                dq.add(node.left);
            }
            if(node.right==null)
            {
                sb.append("n ");
            }
            else
            {
                sb.append(node.right.val+" ");
                dq.add(node.right);
            }
        }
        return sb.toString();
       
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(" ");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty())
        {
            TreeNode node = dq.poll();
            
            if(arr[i].equals("n"))
            {
                node.left = null;
            }
            else
            {
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                dq.add(node.left);
                
            }
            
            
            if(arr[++i].equals("n"))
            {
                node.right = null;
            }
            else
            {
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                dq.add(node.right);
            }
            i++;
            
        }
        return root;
    }
}

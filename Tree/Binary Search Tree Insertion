Binary Search Tree : Insertion
https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

public static Node insert(Node root,int data) {
        Node temp = root;
        Node new_node = new Node(data);
        if(root == null)
        {
            root = new_node;
            return root;
        }
        while(true)
        {
            if(temp.data>data)
            {
                if(temp.left == null)
                {
                    temp.left = new_node;
                    break;
                }
                else
                {
                    temp = temp.left;
                    continue;
                }
            }
            else
            {
                if(temp.right == null)
                {
                    temp.right = new_node;
                    break;
                }
                else{
                    temp = temp.right;
                    continue;
                }
                
            }
        }
        
    	return root;
}


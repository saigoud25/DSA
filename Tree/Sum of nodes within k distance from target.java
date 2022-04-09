Sum of nodes within k distance from target
https://practice.geeksforgeeks.org/problems/ebb840c27b36a8c8ad121fd576a2fa6f2bc1e6f2/1#


/*
->By Using "Target Path & Print k Down Elements method"
->Add the each node data while traversing
*/
class solver{
    static int sum_at_distK(Node root, int target, int k){
        // code here
        ArrayList<Node> arr = new ArrayList<>();
        int[] count = new int[1];
        
        helper(root, target, arr);
        HashSet<Node> set = new HashSet<Node>(arr);
        // for(Node node : arr) System.out.println(node.data);
        // count[0] = arr.get(0).data;
        
        for(int i = 0; i<arr.size(); i++)
        {
            Node t = arr.get(i);
            printKDown(t, k-i, count, set);
        }
        
        return count[0];
    }
    
    static void printKDown(Node root, int k, int[] count, Set<Node> set)
    {
        if(root==null) return;
        if(k<0) return;
        if(k==0)
        {
            // System.out.println(root.data);
            count[0] += root.data;
            return;
        }
        if(!set.contains(root.left)) printKDown(root.left, k-1, count, set);
        if(!set.contains(root.right)) printKDown(root.right, k-1, count, set);
        count[0] += root.data;
        return;
    }
    
    static boolean helper(Node root, int target, ArrayList<Node> arr)
    {
        if(root==null) return false;
        if(root.data==target)
        {
            arr.add(root);
            return true;
        }
        boolean flag = helper(root.left, target, arr);
        if(flag == true)
        {
            arr.add(root);
            return true;
        }
        flag = helper(root.right, target, arr);
        if(flag == true)
        {
            arr.add(root);
            return true;
        }
        return false;
    }
}

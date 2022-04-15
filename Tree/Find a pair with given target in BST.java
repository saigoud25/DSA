Find a pair with given target in BST
https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/


/*
->Using two sum method through HashSet
->If the target-root.data present in Set return 1
->Add the root.data into Set and Traverse the Tree
*/
class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    HashSet<Integer> hm = new HashSet<>();
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        if(root==null) return 0;
        
        if(hm.contains(target-root.data))
        {
            return 1;
        }
        else
        {
            hm.add(root.data);
        }
        if(isPairPresent(root.left, target)==0 && isPairPresent(root.right, target)==0)
        {
            return 0;
        }
        
        return 1;
    }
}

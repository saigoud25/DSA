987. Vertical Order Traversal of a Binary Tree
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

/*
->Traverse the Tree, if going to left decrement the i, if going to right increment the i.
->'i' tells the vertical order of elements
->Create HashMap store the 'i' as key and 'i'th vertical nodes as elements in a PriorityQueue
->PriorityQueue is sorted on two conditions
    ->Here we use level order to keep track of upper elements, upper elements are given priority
    ->If level is same, them priority is based on the values
->Convert the HashMap to the 2D ArrayList to return
*/
class Solution {
    class Pair {
        int val;
        int level;
        Pair(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
    HashMap<Integer, PriorityQueue<Pair>> map;
    int min, max;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        min = 0;
        max = 0;
        map = new HashMap<>();
        
        helper(0, root, 0);
        
        for(int i = min; i<=max; i++) {
            List<Integer> temp = new ArrayList<>();
            
            PriorityQueue<Pair> pq = map.get(i);
            
            while(!pq.isEmpty()) {
                temp.add(pq.poll().val);
            }
            
            list.add(temp);
        }
        
        return list;
    }
    
    public void helper(int i, TreeNode node, int level) {
        
        map.putIfAbsent(i, new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b) {
                if(a.level==b.level) {
                    return Integer.compare(a.val, b.val);
                }
                return Integer.compare(a.level, b.level);
            }
        }));
        
        min = Math.min(i, min);
        max = Math.max(i, max);
        
        map.get(i).add(new Pair(node.val, level));
        
        if(node.left != null) {
            helper(i-1, node.left, level+1);
        }
        
        if(node.right != null) {
            helper(i+1, node.right, level+1);
        }
        
        return;
    }
}

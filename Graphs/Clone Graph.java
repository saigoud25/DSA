133. Clone Graph
https://leetcode.com/problems/clone-graph/
https://www.youtube.com/watch?v=0m_eIw_XW9c

DFS:

class Solution {
    Map<Node, Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        
        Node newNode = new Node(node.val);
        hm.put(node, newNode);
        
        for(Node n : node.neighbors)
        {
            if(!hm.containsKey(n))
            {
                newNode.neighbors.add(cloneGraph(n));
            }
            else
            {
                newNode.neighbors.add(hm.get(n));
            }
        }
        
        return newNode;
    }
}

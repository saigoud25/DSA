BFS of graph
https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
https://www.youtube.com/watch?v=UeE67iCK2lQ

Output: 0 1 2 3 4
Explanation: 
0 is connected to 1 , 2 , 3.
2 is connected to 4.
so starting from 0, it will go to 1 then 2
then 3.After this 2 to 4, thus bfs will be
0 1 2 3 4.

  
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ret = new ArrayList<>();
        boolean visited[] = new boolean[V];
        Deque<Integer> dq = new LinkedList<>();
        dq.add(0);
        visited[0] = true;
        
        while(!dq.isEmpty())
        {
            Integer node = dq.poll();
            ret.add(node);
            
            for(Integer i : adj.get(node))
            {
                if(visited[i] == false)
                {
                    visited[i] = true;
                    dq.add(i);
                }
            }
        }
        return ret;
    }
}

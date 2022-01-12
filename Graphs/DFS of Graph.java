DFS of Graph
https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/
https://www.youtube.com/watch?v=uDWljP2PGmU

Output: 0 1 2 4 3

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> DFSList = new ArrayList<>();
        boolean visited[] = new boolean[V];
        
        dfs(0, adj, DFSList, visited);
        
        return DFSList;
    }
    
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> DFSList, boolean[] visited)
    {
        DFSList.add(i);
        visited[i] = true;
        
        for(Integer n : adj.get(i))
        {
            if(visited[n] == false)
            {
                dfs(n, adj, DFSList, visited);
            }
        }
    }
}

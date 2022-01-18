Topological sort
https://practice.geeksforgeeks.org/problems/topological-sort/1/#
https://www.youtube.com/watch?v=Yh6EFazXipA


//Add elements into stack after the DFS
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        int[] arr = new int[V];
        
        for(int i = 0; i<V; i++)
        {
            if(visited[i] == 0)
            {
                DFS(i, adj, st, visited);
            }
        }
        
        for(int i = 0; i<V; i++)
        {
            arr[i] = st.pop();
        }
        
        return arr;
    }
    
    static void DFS(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] visited)
    {
        visited[i] = 1;
        
        for(Integer ele : adj.get(i))
        {
            if(visited[ele] == 0)
            {
                DFS(ele, adj, st, visited);
            }
        }
        
        st.push(i);
    }
}

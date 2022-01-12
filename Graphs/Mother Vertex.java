Mother Vertex
https://practice.geeksforgeeks.org/problems/mother-vertex/1

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean visited[] = new boolean[V];
        Deque<Integer> dq = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i<V; i++)
        {
            dq.add(i);
            visited[i] = true;
            while(!dq.isEmpty())
            {
                Integer node = dq.poll();
            
                for(Integer in : adj.get(node))
                {
                    if(visited[in] == false)
                    {
                        visited[in] = true;
                        dq.add(in);
                    }
                }
            }
            //After completion of ith node, if all are true in visited array then return i.
            for(int j = 0; j<V; j++)
            {
                if(visited[j] == true)
                {
                    count++;
                }
            }
            
            if(count==V)
            {
                return i;
            }
            count = 0;
            Arrays.fill(visited, false); //set visited array to false
        }

        return -1;
    }
}

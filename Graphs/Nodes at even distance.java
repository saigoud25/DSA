Nodes at even distance 
https://practice.geeksforgeeks.org/problems/nodes-at-even-distance0532/1#
https://youtu.be/uKdw47eas_U


/*
https://youtu.be/uKdw47eas_U
->BFS traverse the all graph and maintain an distance array
->Count all even distances, nC2 
->Count all odd distances, nC2
*/
class Solution
{
    int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        // Write your code here
        int ans = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] visited = new int[n+1];
        int[] distance = new int[n+1];
        int evenCount = 0, oddCount = 0;
        
        dq.add(1);
        visited[1] = 1;
        
        while(!dq.isEmpty())
        {
            int node = dq.poll();
            int dist = distance[node];
            
            for(int i : graph.get(node))
            {
                if(visited[i] == 0)
                {
                    visited[i] = 1;
                    distance[i] = dist+1;
                    dq.add(i);
                }
            }
        }
        // System.out.println(Arrays.toString(distance));
        
        for(int i = 1; i<n+1; i++)
        {
            if(distance[i]%2 == 0)
            {
                evenCount++;
            }
            else
            {
                oddCount++;
            }
        }
        ans += (evenCount*(evenCount-1))/2;
        ans += (oddCount*(oddCount-1))/2;
        return ans;
    }
}

Party in Town
https://practice.geeksforgeeks.org/problems/party-in-town3951/1#


/*
->DFS on All nodes and find the minimnum distance
->While DFS store the distance from ith node to jth node in the dist array,
    ->dist array is also used as visited array, while traversing
    ->for 1->2->3, for 1 DFS traversal
    ->first  update the dist[2] as dist[1]+1
    ->when it reaches 3, update dist[3] as dist[2]+1

*/

class Solution{
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        int ans = Integer.MAX_VALUE, temp = 0;
        for(int i = 1; i<=N; i++)
        {
            temp = dfs(adj, i, N);
            ans = Math.min(ans, temp);
        }
        
        return ans;
    }
    
    static int dfs(ArrayList<ArrayList<Integer>> adj, int node, int N)
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node] = 0;
        dq.add(node);
        int ans = 0;
        
        while(!dq.isEmpty())
        {
            int i = dq.poll();
            
            for(Integer ele : adj.get(i))
            {
                if(dist[ele]==Integer.MAX_VALUE)
                {
                    dq.add(ele);
                    dist[ele] = dist[i]+1;
                    
                    ans = Math.max(ans, dist[ele]);
                }
            }
        }
        
        return ans;
    }
}

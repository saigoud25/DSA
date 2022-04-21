1971. Find if Path Exists in Graph
https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/

/*
->DFS of a graph
->Start DFS from all nodes, which are not visited
->When DFS of '0' node starts add the elements in an set,
    ->If that set contains both start and end values return true
->If '0' node don't have both values, now call DFS from node 1/next unvisited node
->Repeat upto all nodes are visited
*/
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] i : edges)
        {
            if(!map.containsKey(i[0]))
            {
                map.put(i[0], new ArrayList<Integer>());
            }
            map.get(i[0]).add(i[1]);
            if(!map.containsKey(i[1]))
            {
                map.put(i[1], new ArrayList<Integer>());
            }
            map.get(i[1]).add(i[0]);
        }
        // System.out.println(map);
        
        int[] visited = new int[n];
        for(int i = 0; i<n && visited[i]==0; i++)
        {
            Set<Integer> set = new HashSet<>();
            Deque<Integer> dq = new ArrayDeque();
            dq.add(i);
            set.add(i);
            while(!dq.isEmpty())
            {
                int node = dq.poll();
                visited[node] = 1;
                set.add(node);
                for(Integer ele : map.get(node))
                {
                    if(visited[ele]==0)
                    {
                        dq.add(ele);
                    }
                }
            }
            if(set.contains(start) && set.contains(end)) return true;
        }
        
        return false;
    }
}

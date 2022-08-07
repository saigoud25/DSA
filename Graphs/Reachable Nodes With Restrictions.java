2368. Reachable Nodes With Restrictions
https://leetcode.com/problems/reachable-nodes-with-restrictions/

/*
->Using BFS (Queue) 
->Create a Adjacency List, map
->Remove the restricted edges from the map
->Simply do BFS and count the total number of visited nodes
*/
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        
        for(int i : restricted) {
            set.add(i);
        }
        
        for(int[] i : edges) {
            if(!map.containsKey(i[0])) {
                map.put(i[0], new ArrayList<Integer>());
            }
            if(!map.containsKey(i[1])) {
                map.put(i[1], new ArrayList<Integer>());
            }
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        
        for(Integer i : set) {
            map.remove(i);
        }

        q.add(0);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            if(set.contains(node)) continue;
            count++;
            visited.add(node);
            
            for(int k : map.get(node)) {
                if(!visited.contains(k)) {

                    q.add(k);
                }
            }
                
        }
        
        
        return count;
    }
}

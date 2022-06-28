2316. Count Unreachable Pairs of Nodes in an Undirected Graph
https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

/*
->Using Union-Find Method
->Create a unionArr find unions of each node
->Create a HashMap, union root as a key and union size as value
->ans = n * size of union, before each iteration remove size of union from n, i.e.,(n -= map.get(i))
*/
class Solution {
    int[] unionArr;
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        unionArr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        // Arrays.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i<n; i++) unionArr[i] = i;
        for(int[] i : edges)
        {
            union(i[0], i[1]);
        }
        for(int i = 0; i<n; i++)
        {
            int root = find(i);
            
            map.put(root, map.getOrDefault(root, 0)+1);
        }
        
        for(int i : map.keySet())
        {
            n -= map.get(i);
            ans += 1L * map.get(i)*n;
        }

        return ans;
    }

    public int find(int node)
    {
        while(unionArr[node] != node)
        {
            node = unionArr[unionArr[node]]; //Path compression
        }
        
        return node;
    }
        
    public void union(int i, int j)
    {
        int iRoot = find(i);
        int jRoot = find(j);
        
        unionArr[jRoot] = iRoot;
    }
}

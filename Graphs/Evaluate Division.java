399. Evaluate Division
https://leetcode.com/problems/evaluate-division/
https://www.youtube.com/watch?v=UcDZM6Ap5P4

DFS:

class Solution {
    class Node
    {
        String key;
        double val;
        public Node(String k, double v)
        {
            key = k;
            val = v;
        }
    }
        
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //First Create HashMap to create a Graph
        Map<String, List<Node>> hm = helper(equations, values);
        double[] results = new double[queries.size()];
        
        for(int i = 0; i<queries.size(); i++)
        {
            String s = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            
            results[i] = dfs(s, d, hm, new HashSet());
        }
        
        return results;
    }
    
    public double dfs(String s, String d, Map<String, List<Node>> hm, HashSet<String> visited)
    {
        if(!(hm.containsKey(s) && hm.containsKey(d)))
        {
            return -1.0;
        }
        
        if(s.equals(d))
        {
            return 1;
        }
        
        visited.add(s);
        
        for(Node n : hm.get(s))
        {
            if(!visited.contains(n.key))
            {
                double ans = dfs(n.key, d, hm, visited);
                
                if(ans != -1.0)
                {
                    return ans * n.val;
                }
            }
        }
        
        return -1.0;
    }
    
    public Map<String, List<Node>> helper(List<List<String>> equations, double[] values)
    {
        Map<String, List<Node>> hm = new HashMap<>();
        
        for(int i = 0; i<values.length; i++)
        {
            String s = equations.get(i).get(0);
            String d = equations.get(i).get(1);
            hm.putIfAbsent(s, new ArrayList());
            hm.putIfAbsent(d, new ArrayList());
            hm.get(s).add(new Node(d, values[i]));
            hm.get(d).add(new Node(s, 1.0/values[i]));
        }
        
        return hm;
    }
}

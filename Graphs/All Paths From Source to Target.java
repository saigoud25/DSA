797. All Paths From Source to Target
https://leetcode.com/problems/all-paths-from-source-to-target/description/

/*
->Using DFS Traversal
->Create an Adjacency List(HashMap not needed)
->Traverse from 0, maintain an array add all travesed elements
->If reached target, add the array into result
->Remove the array values after traversing
*/

class Solution {
    List<List<Integer>> res;
    int target;
    HashMap<Integer, ArrayList<Integer>> map;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        map = new HashMap<>();
        res = new ArrayList<>();
        target = graph.length-1;
        int pos = 0;
        
        for(int[] i : graph) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int ele : i) {
                arr.add(ele);
            }
            map.put(pos++, arr);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        dfs(0, arr);

        return res;
    }
    public void dfs(int node, ArrayList<Integer> arr) {
        if(node==target) {
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i : map.get(node)) {
            arr.add(i);
            dfs(i, arr);
            arr.remove(arr.size()-1);
        }

        return;
    }
}

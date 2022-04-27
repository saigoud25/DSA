1202. Smallest String With Swaps
https://leetcode.com/problems/smallest-string-with-swaps/submissions/
https://youtu.be/O3jr8HOpkUU

/*
https://youtu.be/O3jr8HOpkUU
->Using Union Find Method 
https://youtu.be/Cb6p18e9c8s //for union find class creation
->Create a Union class and complete the find() and union() functions
->First find the roots of all elements
->Add string characters into hashmap, find(i) as a key and PriorityQueue as a value
->Now iterate through the range of s.length, 
    ->If(find[i]) is 0, then add the 0th key value(Queue) element to StringBuilder
*/
class Solution {
    class Union{
        public int[] arr;
        Union(int n)
        {
            arr = new int[n];
            for(int i = 0; i<n; i++) arr[i] = i;
        }
        
        int find(int node)
        {
            if(arr[node] == node)
            {
                return node;
            }
            
            return arr[node] = find(arr[node]);
        }
        
        void union(int i, int j)
        {
            int iRoot = find(i);
            int jRoot = find(j);
            
            if(iRoot != jRoot)
            {
                arr[jRoot] = iRoot;
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Union u = new Union(s.length());
        for(List<Integer> i : pairs)
        {
            u.union(i.get(0), i.get(1));
        }
        
        for(int i = 0; i<s.length(); i++)
        {
            int ele = u.find(i);
            if(!map.containsKey(ele))
            {
                map.put(ele, new PriorityQueue<Character>());
            }
            map.get(ele).add(s.charAt(i));
        }
        
        for(int i = 0; i<s.length(); i++)
        {
            int ele = u.find(i);
            sb.append(map.get(ele).poll());
        }
        
        return sb.toString();
    }
}

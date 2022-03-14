Biconnected Graph
https://practice.geeksforgeeks.org/problems/biconnected-graph2528/1#

/*
->Create the HashMap nodes as keys and node edges as values
->If any key have less than or equal to 1 (hm.get(i)<=1) return 0
->If all nodes(keys) have more than one edges than return 1;
*/
class Solution {
    static int biGraph(int[] arr, int n, int e) {
        // code here
        if(n==2 && e==1) return 1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<arr.length; i += 2)
        {
            int ele1 = arr[i];
            int ele2 = arr[i+1];
            hm.put(ele1, hm.getOrDefault(ele1, 0)+1);
            hm.put(ele2, hm.getOrDefault(ele2, 0)+1);
        }
        // System.out.println(hm);
        for(Integer i : hm.keySet())
        {
            if(hm.get(i)<=1) return 0;
        }
        return 1;
    }
};

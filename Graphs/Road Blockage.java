Road Blockage
https://practice.geeksforgeeks.org/contest/job-a-thon-exclusive-hiring-challenge-for-amazon-alexa/problems#
https://youtu.be/7JwGNqNDevM?t=3198


/*
->Using the Euler Tour method
https://youtu.be/7JwGNqNDevM?t=3198

->Find the Euler Tour Array by DFS traversal
->Find the level of nodes
->Truncate the Blockage node(ith to jth)(which has high level from query) from Euler Tour,
->After take the maximum of left[i-1] and right[j+1]
->Left and Right are prefix and suffix sums of highest levels based on Euler Tour Array elements
->Simply Watch Youtube Video
*/

// User function Template for Java
class Solution {
    static HashMap<Integer, Integer> levelMap;
    public static int[] solve(int N, int Q, int[][] Edge, int[][] query) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> eulerTour = new ArrayList<>();
        levelMap = new HashMap<>();
        for(int[] i : Edge)
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
        
        dfs(0, 0, map, new HashSet<Integer>(), eulerTour);
        
        int[] left = new int[eulerTour.size()];
        int[] right = new int[eulerTour.size()]; 
        int temp = 0, k = 0;
        for(int i : eulerTour)
        {
            temp = Math.max(temp, levelMap.get(i));
            left[k++] = temp;
        }
        temp = 0; k = eulerTour.size()-1;
        while(k>=0)
        {
            temp = Math.max(temp, levelMap.get(eulerTour.get(k)));
            right[k--] = temp;
            
        }
        int[] ans = new int[query.length];
        
        //Store the first and last occurance of elements in a EularTour array
        HashMap<Integer, int[]> begend = new HashMap<>();

        for(int i = 0 ; i<eulerTour.size(); i++)
        {
            int ele = eulerTour.get(i);
            if(!begend.containsKey(ele))
            {
                int[] arr = {i, 0};
                begend.put(ele, arr);
            }
            begend.get(ele)[1] = i;
        }

        k = 0;
        for(int[] i : query)
        {
            
            int depth = i[1];
            
            if(levelMap.get(i[1])<levelMap.get(i[0]))
            {
                depth = i[0];
            }

            ans[k] = Math.max(left[begend.get(depth)[0]-1], right[begend.get(depth)[1]+1]);
            k++;
        }
        
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        // System.out.println(eulerTour);
        // System.out.println(levelMap);
        return ans;
    }
    
    public static void dfs(int i, int level, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set, ArrayList<Integer> eulerTour)
    {
        set.add(i);
        // System.out.println(i+" "+level);
        levelMap.put(i, level);
        eulerTour.add(i);
        for(int node : map.get(i))
        {
            if(!set.contains(node))
            {
                dfs(node, level+1, map, set, eulerTour);
            }
        }
        eulerTour.add(i);
    }
}

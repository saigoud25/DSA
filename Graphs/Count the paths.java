Count the paths 
https://practice.geeksforgeeks.org/problems/count-the-paths4332/1

/*
->By using BFS
->Add the source to the Deque, from source traverse to the Destination
->Increment the count if reach the Destination
*/
class Solution
{
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        // Code here 
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int count = 0;
        if(s==d) return 1;
        for(int[] i : edges)
        {
            if(!map.containsKey(i[0]))
            {
                map.put(i[0], new ArrayList<Integer>());
            }
            map.get(i[0]).add(i[1]);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        
        while(!dq.isEmpty())
        {
            Integer i = dq.poll();
            if(map.get(i)!=null)
            for(Integer k : map.get(i))
            {
                if(k==d)
                {
                    count++;
                    continue;
                }
                dq.add(k);
            }
        }
        
        return count;
    }
}

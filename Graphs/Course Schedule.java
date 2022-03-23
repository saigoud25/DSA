207. Course Schedule
https://leetcode.com/problems/course-schedule/
https://youtu.be/V6GxfKDyLBM

/*
https://youtu.be/V6GxfKDyLBM
->Using Topological Sort(Khans's Algorithm) to Detect Cyclic in Directed Graph
->Create Adjacency List using given prerequisites array
->Find the InDegree of each element
->add element into dequeue who has inDegree 0
->Now iterate through dequeue until queue is empty
->decrement the inDegree if the element is visited once
->count all elements with inDegree
->If count is equal to numCourses return true, else false
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        int count = 0;

        for(int[] i : prerequisites)
        {
            if(hm.containsKey(i[0]))
            {
                ArrayList<Integer> list = hm.get(i[0]);
                list.add(i[1]);
                hm.put(i[0], list);
            }
            else
            {
                hm.put(i[0], new ArrayList<Integer>());
                hm.get(i[0]).add(i[1]);
            }
            inDegree[i[1]]++;
        }

        for(Integer i = 0; i<inDegree.length; i++)
        {
            if(inDegree[i]==0)
            {
                dq.add(i);
            }
        }

        while(!dq.isEmpty())
        {
            count++;
            int ele = dq.poll();
            if(!hm.containsKey(ele)) continue;
            for(Integer i : hm.get(ele))
            {
                inDegree[i]--;
                if(inDegree[i]==0)
                {
                    dq.add(i);
                }
            }
        }
        
        if(count==numCourses) return true;
        return false; 
    }
}

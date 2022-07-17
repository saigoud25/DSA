2343. Query Kth Smallest Trimmed Number
https://leetcode.com/problems/query-kth-smallest-trimmed-number/


/*
->Create a PriorityQueue which sort the values based on the comparator, if length of string are equal removes the high index element, else compare the both strings removes the string with high value
*/
class Solution {
    class Pair {
        String data;
        int ind;
        Pair(String data, int ind)
        {
            this.data = data;
            this.ind = ind;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( new Comparator<>()
                                                         {
                                                             @Override
                                                             public int compare(Pair a, Pair b)
                                                             {
                                                                 if(b.data.compareTo(a.data)==0)
                                                                 {
                                                                     return b.ind-a.ind;
                                                                 }
                                                                 return b.data.compareTo(a.data);
                                                             }
                                                         });
        int n = queries.length;
        int[] arr = new int[n];
        int len = nums[0].length();
        int ind = 0;
        for(int[] i : queries)
        {
            for(int j = 0; j<nums.length; j++)
            {
                String s = nums[j].substring(len-i[1]);
                pq.add(new Pair(s, j));
                if(pq.size() > i[0])
                {
                    pq.poll();
                }
            }
            arr[ind++] = pq.peek().ind;
            pq.clear();
        }
        
        return arr;
    }
}

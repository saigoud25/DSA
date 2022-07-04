1962. Remove Stones to Minimize the Total
https://leetcode.com/problems/remove-stones-to-minimize-the-total/

/*
->Using PriorityQueue (Max Heap)
->Remove the max element from queue and divide it by 2 and again add it into to queue, repeat it k times
*/
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for(int i : piles) 
        {
            pq.add(i);
            sum += i;
        }
        
        for(int i = 0; i<k; i++)
        {
            int ele = pq.poll();
            sum -= ele/2;
            pq.add((int)Math.ceil(ele/2.0));
        }
                
        return sum;
    }
}

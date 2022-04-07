1046. Last Stone Weight
https://leetcode.com/problems/last-stone-weight/

/*
->Add all elements into PriorityQueue(Max Heap)
->Remove last two elements and add difference of them again to PriorityQueue
->Traverse the pq until it should have more than 1 element
->return the last element of pq
*/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) pq.add(i);
        
        while(pq.size()>1)
        {
            int ele1 = pq.poll();
            int ele2 = pq.poll();
            // System.out.println(ele1+"-"+ele2);
            int k = ele1-ele2;
            pq.add(k);
        }
        
        return pq.poll();
    }
}

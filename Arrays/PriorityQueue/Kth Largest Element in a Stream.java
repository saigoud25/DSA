703. Kth Largest Element in a Stream
https://leetcode.com/problems/kth-largest-element-in-a-stream/

/*
->Maintain a PriorityQueue of length k
->If the length of pq is less than k, directly add elements
->If length of pq is greater than k,
    ->Check if val is greater than pq.peek()
    ->If true, remove the smallest element from pq and add new val
    ->Else skip the val and return pq.peek()
*/
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums)
        {
            if(pq.size()<k)
            {
                pq.add(i);
            }
            else
            {
                if(pq.peek()<i)
                {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()<k)
        {
            pq.add(val);
        }
        else if(pq.peek()<val)
        {
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

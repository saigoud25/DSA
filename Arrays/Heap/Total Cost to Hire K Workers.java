2462. Total Cost to Hire K Workers
https://leetcode.com/problems/total-cost-to-hire-k-workers/

/*
->Using 2 PriorityQueue's
->Store first number of can in pq1
->Store last number of can in pq2

->Iterate k times, compare and remove k elements from the 2 pq's
*/
class Solution {
    
    static final Comparator<int[]> comparator = (a, b) -> {
        int diff = Integer.compare(a[0], b[0]);
        
        if(diff == 0) {
            return Integer.compare(a[1], b[1]);
        }
        
        return diff;
    };
    
    public long totalCost(int[] costs, int k, int can) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(comparator);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(comparator);
        
        int n = costs.length;
        int left = 0;
        int right = n-1;
        long sum = 0l;
        
        while(k-- > 0) {
            while(pq1.size()<can && left<=right) {
                pq1.add(new int[]{costs[left], left++});
            }
            
            while(pq2.size()<can && left<=right) {
                pq2.add(new int[]{costs[right], right--});
            }
            
            if(pq2.isEmpty()) {
                sum += pq1.poll()[0];
                continue;
            }
            if(pq1.isEmpty()) {
                sum += pq2.poll()[0];
                continue;
            }
            
            if(pq1.peek()[0] > pq2.peek()[0]) {
                sum += pq2.poll()[0];
            } else  {
                sum += pq1.poll()[0];
            }
            
        }

        return sum;
    }
}

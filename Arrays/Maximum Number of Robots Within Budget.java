2398. Maximum Number of Robots Within Budget
https://leetcode.com/problems/maximum-number-of-robots-within-budget/

/*
->Using Sliding Window
https://leetcode.com/problems/maximum-number-of-robots-within-budget/discuss/2524838/JavaC%2B%2BPython-Sliding-Window-O(n)-Solution
->Maintain a Queue which acts as Max Stack
*/
class Solution {
    public int maximumRobots(int[] times, int[] costs, long budget) {
        Deque<Integer> dq = new LinkedList<>();        
        int i = 0, n = times.length;
        long sum = 0;
        
        for(int j = 0; j<n;  j++) {
            sum += costs[j];
            
            while(!dq.isEmpty() && times[dq.peekLast()] <= times[j]) {
                dq.pollLast();
            }
            
            dq.addLast(j);
                        
            if(times[dq.getFirst()] + (j-i+1)*sum > budget) {
                if(dq.getFirst()==i) {
                    dq.pollFirst();
                }
                
                sum -= costs[i++];
            }
        }
        
        return n-i;
    }
}

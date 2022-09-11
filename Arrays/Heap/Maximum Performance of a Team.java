1383. Maximum Performance of a Team
https://leetcode.com/problems/maximum-performance-of-a-team/
https://youtu.be/vlZYnDtJayw

/*
https://youtu.be/vlZYnDtJayw
->Sort the effieciency array in decreasing order, speed and efficiency are related so
    ->Create a new 2D array, add both array values and then sort
->Create a Min Heap, which stores atmost K elements
->Iterate through the Array and find the performance and update the 'max' accordingly
*/
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        long max = 0, sum = 0;
        
        for(int i = 0; i<n; i++) {
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] i : arr) {
            sum += i[1];
            pq.add(i[1]);
            
            if(pq.size() > k) {
                sum -= pq.poll();
            }
            
            max = Math.max(max, sum*i[0]);
        }

        return (int)(max%1000000007);
    }
}

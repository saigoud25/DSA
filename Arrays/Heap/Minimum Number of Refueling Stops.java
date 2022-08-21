871. Minimum Number of Refueling Stops
https://leetcode.com/problems/minimum-number-of-refueling-stops/
https://youtu.be/tAdMNnd3CII


/*
https://youtu.be/tAdMNnd3CII
https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy

->Collect all station fuels upto maxDis, when fuel exausted pick high fuel and increment the stops
*/
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, stops = 0;
        int maxDis = startFuel;
        
        while(maxDis < target) {
            while(i<stations.length && stations[i][0]<=maxDis) {
                pq.add(stations[i++][1]);
            }
            
            if(pq.isEmpty()) return -1;
            
            maxDis += pq.poll();
            stops++;
        }
        
        return stops;
    }
}

1396. Design Underground System
https://leetcode.com/problems/design-underground-system/submissions/


/*
->Using HashMaps
->1 is to stores the startStation and startTime of passenger of given ID
->started = HashMap<id, Pair(startStation, time)>
->Pair is a UserDefined class stored startStation and time

->2 is to stores the arrival details, it stores startStation as a key and
    ->value is HashMap, in which key is endStation and Array as value
        ->Array contains 2 values, Array[0] is total sum of distance, Array[1] is total passengers.
->arrived = HashMap<startStation, HashMap<endStation, [sum, count]>>

->To get the Average Time, 
->Values are stored in array, arrived.get(startStation).get(endStation);
->Array[0] is sum of distances, Array[1] is total passengers
->Answer is sumOfDistances/TotalPassengers
*/
class UndergroundSystem {
    class Pair
    {
        public String source;
        public int ci_t;
        Pair(String s, int t)
        {
            source = s;
            ci_t = t;
        }
    }    
    HashMap<Integer, Pair> started;
    HashMap<String, HashMap<String, int[]>> arrived;
    
    public UndergroundSystem() {
        started = new HashMap<Integer, Pair>();
        arrived = new HashMap<String, HashMap<String, int[]>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        started.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = started.get(id);
        if(!arrived.containsKey(p.source))
        {
            arrived.put(p.source, new HashMap<String, int[]>());
        }
        HashMap h = arrived.get(p.source);
        
        if(!h.containsKey(stationName))
        {
            int[] temp = new int[2];
            h.put(stationName, temp);
            arrived.put(p.source, h);
        }

        int[] temp = arrived.get(p.source).get(stationName);
        int d = t-p.ci_t;
        temp[0] += d;
        temp[1]++;

        arrived.get(p.source).put(stationName, temp);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        int[] temp = arrived.get(startStation).get(endStation);
        double ans = (double)temp[0]/temp[1];
        return ans;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

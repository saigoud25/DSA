981. Time Based Key-Value Store
https://leetcode.com/problems/time-based-key-value-store/

/**
1.Create a Hashmap with key is key and List<Data> as the value, Data is a class stores timestamp and value
hm = {
        foo: [(bar,1), (bar2,4)] 
     }
2. hm.get(key) returns the List of type Class Data, 
 ->Now BinarySearch on object.time in List, to get the floorTime<=Time, return the object.value
*/

class Data
{
    String value;
    int time;
    Data(){}
    Data(String value, int time)
    {
        this.value = value;
        this.time = time;
    }
}
class TimeMap {
    HashMap<String, List<Data>> hm;
    public TimeMap() {
        hm = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key))
        {
            hm.put(key, new ArrayList<Data>());
        }
        hm.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        return binarySearch(hm.get(key), timestamp);
    }
    public String binarySearch(List<Data> data, int timestamp)
    {   
        int start = 0, end = data.size()-1, mid = 0;

        while(start<end)
        {
            mid = start+(end-start)/2;
            if(data.get(mid).time == timestamp) return data.get(mid).value;
            if(data.get(mid).time<timestamp)
            {
                if(data.get(mid+1).time>timestamp) return data.get(mid).value;
                start = mid+1;
            }
            else end = mid-1;
        }
        return data.get(start).time <= timestamp ? data.get(start).value : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

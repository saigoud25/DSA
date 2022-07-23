2349. Design a Number Container System
https://leetcode.com/problems/design-a-number-container-system/

/*
->ch HashMap stores index as key and number as value
->map HashMap stores Number as key and NumberContainer as value
->If the ch HashMap contains the key,
    ->Remove the index from the old number key in the map
->Else simply add new index and value in the ch HashMap
->Add the new index in the new NumberContainer, number as the key in the map HashMap
*/
class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> map;
    HashMap<Integer, Integer> ch;
    public NumberContainers() {
        map = new HashMap<>();
        ch = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(ch.containsKey(index)) {
            int prev = ch.get(index);
            map.get(prev).remove(index);
            if(map.get(prev).size()==0) map.remove(prev);
        }

        map.putIfAbsent(number, new TreeSet<Integer>());
        map.get(number).add(index);
        
        ch.put(index, number);
    }
    
    public int find(int number) {
        if(!map.containsKey(number)) return -1;
        
        return map.get(number).first();
    }
}

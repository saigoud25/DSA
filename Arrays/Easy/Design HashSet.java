/*
705. Design HashSet
Design HashSet

->Use Array to represent Set values, create an array of length 10^6+1
->to add value, change the array value to 1
->If array value at location key is 1, i.e., it is present
*/
class MyHashSet {
    int[] arr;
    public MyHashSet() {
        arr = new int[(int)Math.pow(10, 6)+1];
    }
    
    public void add(int key) {
        arr[key] = 1;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
    
    public boolean contains(int key) {
        if(arr[key]==1) return true;
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

706. Design HashMap
https://leetcode.com/problems/design-hashmap/

/*
->Using Array, use array index as a key and array elements as a value
->First declare an array with size 1, increment the array size if key value in put function is greater than the previous array
*/
class MyHashMap {
    int[] arr;
    int n = 1;
    public MyHashMap() {
        arr = new int[n];
        Arrays.fill(arr, -1);
    }
    
    public void put(int key, int value) {
        if(key>=n)
        {
            int[] newArr = new int[key+n+1];
            Arrays.fill(newArr, -1);
            System.arraycopy(arr, 0, newArr, 0, n);
            n = newArr.length;
            arr = newArr;
        }
        arr[key] = value;
    }
    
    public int get(int key) {
        if(key>=n) return -1;
        return arr[key];
    }
    
    public void remove(int key) {
        if(key>=n) return;
        arr[key] = -1;
        return;
    }
}

380. Insert Delete GetRandom O(1)
https://leetcode.com/problems/insert-delete-getrandom-o1/


import java.util.*;
import java.lang.*;
class RandomizedSet {
    
    HashSet<Integer> hs;
    ArrayList<Integer> arr;
    Random rand;
    Integer[] A;
    
    public RandomizedSet() {
        hs = new HashSet<>();
        arr = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(hs.contains(val))
        {
            return false;
        }
        hs.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hs.contains(val))
        {
            return false;
        }
        hs.remove(val);
        return true;
    }
    
    public int getRandom() {
        A = hs.toArray(new Integer[hs.size()]);
        int ind = rand.nextInt(A.length);
        int num = A[ind];
        
        return num;
    }
}

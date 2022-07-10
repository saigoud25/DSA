2336. Smallest Number in Infinite Set
https://leetcode.com/problems/smallest-number-in-infinite-set/

/*
->Maintain a variable which stores the minimum element
->In addBack function, directly add the element into set.
->In popSmallest function, If the set is empty return the variable and increment the variable
    ->If the ele and set.first() is same return the element and remove the element from the set.
    ->If ele is smaller return ele and increment ele
    ->If set.first() is smaller than the ele, return and remove the set.first()
*/
class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int ele;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        ele = 1;
    }
    
    public int popSmallest() {
        
        if(set.isEmpty())
        {
            ele++;
            return ele-1;
        }
        int temp = set.pollFirst();
        if(ele == temp)
        {
            ele++;
            return temp;
        }
        if(ele<temp)
        {
            ele++;
            set.add(temp);
            return ele-1;
        }
        else
        {
            return temp;
        }
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

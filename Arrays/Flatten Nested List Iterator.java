341. Flatten Nested List Iterator
https://leetcode.com/problems/flatten-nested-list-iterator/

/*
->First Convert the nestedList as a simple Array
->Iterate through the nestedList, If i is Integer add it into arr, else call the func(i)
*/
public class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> arr = new ArrayList<>();
    int ind = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger i : nestedList) {
            func(i);
        }
        // System.out.println(arr);
    }
    
    public void func(NestedInteger i) {
        if(i.isInteger()) {
            arr.add(i.getInteger());
        }
        else {
            for(NestedInteger k : i.getList()) {
                func(k);
            }
        }
        return;
    }

    @Override
    public Integer next() {
        return arr.get(ind++);
    }

    @Override
    public boolean hasNext() {
        return ind != arr.size();
    }
}

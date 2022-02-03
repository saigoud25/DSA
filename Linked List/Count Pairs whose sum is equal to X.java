Count Pairs whose sum is equal to X 
https://practice.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1

/*
1.Create a HashSet and add head1 list in HashSet
2.Iterate through list2 and check x-list(i), i.e,(3-2=1)is contains in HashSet, if set contains increment count
*/
class Solution {
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        // add your code here
        int count = 0;
        Set<Integer> set = new HashSet();
        for(Integer i : head1) set.add(i);
        for(Integer i : head2)
        {
            if(set.contains(x-i)) count++;
        }
        return count;
    }
}

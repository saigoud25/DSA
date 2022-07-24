2350. Shortest Impossible Sequence of Rolls
https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/


/*
https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/discuss/2322280/JavaC%2B%2BPython-One-Pass-O(K)-Space

->we just check for number of k length sets in the arrays, return sets+1
->If there are 2 k length sets, which means you can pick 1 element from each set, i.e., 2 length sequence possible
*/
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for(int i : rolls) {
            set.add(i);
            if(set.size() == k) {
                ans++;
                set.clear();
            }
        }
        return ans;
    }
}

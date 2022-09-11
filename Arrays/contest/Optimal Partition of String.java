2405. Optimal Partition of String
https://leetcode.com/problems/optimal-partition-of-string/

/*
->Using set, if the set contains the ch
    ->Increment count and clear the set;
*/
class Solution {
    public int partitionString(String s) {
        int count = 1;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        
        while(i < s.length()) {
            char ch = s.charAt(i++);
            
            if(set.contains(ch)) {
                count++;
                set.clear();
                set.add(ch);
            }
            else {
                set.add(ch);
            }
        }
        
        return count;
    }
}

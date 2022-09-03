967. Numbers With Same Consecutive Differences
https://leetcode.com/problems/numbers-with-same-consecutive-differences/

/*
->Using Backtracking, first find the first element
->Then find all other elements by checking conditions
*/
class Solution {
    List<String> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();
        
        //finding first element 
        for(int i = 1; i<=9; i++) {
            if((i+k)<=9 || (i-k)>=0) {
                helper(""+i, n-1, k, i);
            }
        }
        
        int[] arr = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++) {
            arr[i] = Integer.parseInt(list.get(i));
        }
        
        return arr;
    }
    
    public void helper(String s, int n, int k, int prev) {
        //Base Condition
        if(n==0) {
            list.add(s);
            return;
        }

        for(int i = 0; i<=9; i++) {
            if(Math.abs(prev-i)==k) {
                helper(s+i, n-1, k, i);
            }
        }
        
        return;
    }
}

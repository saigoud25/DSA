386. Lexicographical Numbers
https://leetcode.com/problems/lexicographical-numbers/

/*
->First find the all occurence of 1, then 2, 3, etc....
*/
class Solution {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for(int i = 1; i<=9; i++) {
            func(i, n);
        }
        return res;
    }
    public void func(int i, int n) {
        if(i>n) return;
        res.add(i);
        
        for(int k = 0; k<=9; k++) {
            if(i*10> n) return;
            func(i*10 + k, n);
        }
        return;
    }
}

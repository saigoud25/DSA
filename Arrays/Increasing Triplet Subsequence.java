334. Increasing Triplet Subsequence
https://leetcode.com/problems/increasing-triplet-subsequence/

/*
->Take two variables, smalla and big. Initialize them with MAX_VALUE
->If the current value is less than small update small with curr values, else if curr value is 
less than big update big with curr values, else return true,
->Which means the curr value is bigger than small and big
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        
        for(int i : nums) {
            if(i <= small) {
                small = i;
            } else if(i <= big) {
                big = i;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

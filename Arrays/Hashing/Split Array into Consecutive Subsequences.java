659. Split Array into Consecutive Subsequences
https://leetcode.com/problems/split-array-into-consecutive-subsequences/
https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/844738/Java-or-Very-easy-explanation-through-a-story-or-Time-O(n)-Space-O(n)

/*
https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/844738/Java-or-Very-easy-explanation-through-a-story-or-Time-O(n)-Space-O(n)
->Check above article
*/
class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> available = new HashMap<>();
        HashMap<Integer, Integer> want = new HashMap<>();
        
        for(int i : nums) {
            available.put(i, available.getOrDefault(i, 0)+1);
        }
        
        for(int i : nums) {
            //When i not availble
            if(available.get(i)<=0) {
                continue;
            }
            //Check whether anyone want i
            else if(want.getOrDefault(i, 0)>0) {
                want.put(i, want.getOrDefault(i, 0)-1);
                available.put(i, available.getOrDefault(i, 0)-1);
                
                want.put(i+1, want.getOrDefault(i+1, 0)+1);
            }
            //Check i can form group
            else if(available.getOrDefault(i, 0)>0 && available.getOrDefault(i+1, 0)>0 && available.getOrDefault(i+2, 0)>0) {
                available.put(i, available.get(i)-1);
                available.put(i+1, available.get(i+1)-1);
                available.put(i+2, available.get(i+2)-1);
                
                want.put(i+3, want.getOrDefault(i+3, 0)+1);
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}

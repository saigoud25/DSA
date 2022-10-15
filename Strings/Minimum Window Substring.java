76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/

/*
->There are other optimised methods

->Method-2
->Original HashMap contains the frequency of characters of "t" string
->Curr HashMap is used to store the frequency of traversing 


->keep the lefft and right pointers, at the first character which appears in "t"
->Traverse the "s" string, if the current is contains in the original HashMap, check whether the 
    Orignal and Curr are equal, if they are equal it's substring, calculate the length and update the 
    max and ans variables.
    ->remove the left character from the Curr HashMap, check again
*/
class Solution {
    public String minWindow(String str, String t) {
        //Method-2
        HashMap<Character, Integer> original = new HashMap<>();
        HashMap<Character, Integer> curr = new HashMap<>();
        
        for(char ch : t.toCharArray()) {
            original.put(ch, original.getOrDefault(ch, 0)+1);
        }
        
        char[] s = str.toCharArray();
        int right = 0, left = 0, n = str.length();
        int max = Integer.MAX_VALUE;
        String ans = "";
        
        while(right < n && !original.containsKey(s[right])) {
            right++;
            left++;
        }
        
        if(right==n) {
            return ans;
        }
        
        while(right < n) {
            if(!original.containsKey(s[right])) {
                right++;
                continue;
            }
            curr.put(s[right], curr.getOrDefault(s[right], 0)+1);
            while(check(curr, original)) {
                if(max > right-left) {
                    max = right-left;
                    ans = str.substring(left, right+1);
                }
                
                if(curr.get(s[left]) > 1) {
                    curr.put(s[left], curr.get(s[left])-1);
                } else {
                    curr.remove(s[left]);
                }
                left++;
                while(left<n && !original.containsKey(s[left])) {
                    left++;
                }
            }
            
            right++;
        }
        
        return ans;
    }
    
    public boolean check(HashMap<Character, Integer> curr, HashMap<Character, Integer> original) {
        for(char ch : original.keySet()) {
            if(curr.getOrDefault(ch, 0) < original.get(ch)) {
                return false;
            }
        }
        
        return true;
    }
}

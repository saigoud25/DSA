869. Reordered Power of 2
https://leetcode.com/problems/reordered-power-of-2/

/*
->Using the concept of finding Anagrams
->Make given n as an sorted String, check whether that string is Matching with Sorted Strings from power of 2's
*/
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        String s1 = new String(arr);
        
        for(int i = 0; i<31; i++) {
            char[] temp = String.valueOf((int)(1<<i)).toCharArray();
            Arrays.sort(temp);
            if(s1.equals(new String(temp))) return true;
        }
        
        return false;
    }
}

6. Zigzag Conversion
https://leetcode.com/problems/zigzag-conversion/

/*
->Make k length Array of Strings
->Each time add the character to the specific String in the array
->the position of array should be, 12345432123454321
*/
class Solution {
    public String convert(String s, int k) {
        if(k==1) return s;
        
        StringBuilder[] arr = new StringBuilder[k];
        int t = 0;
        for(StringBuilder sb : arr) {
            arr[t++] = new StringBuilder();
        }
        
        int i = 0, pos = 0;
        boolean up = true;
        
        while(i<s.length()) {
            arr[pos].append(s.charAt(i++));
            if(up) {
                pos++;
                if(pos==k-1) {
                    up = false;
                }
            } else {
                pos--;
                if(pos==0) {
                    up = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(StringBuilder word : arr) {
            sb.append(word);
        }
        
        return sb.toString();
    }
}

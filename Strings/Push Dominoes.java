838. Push Dominoes
https://leetcode.com/problems/push-dominoes/

/*
->Traverse from right to left and increment the left values, 
->Traverse from left to right and increment the right values

->If the left and right values are same, make char as '.'
->If left value is less than right value, make char as 'L'
->If right value is less than left value, make char as 'R'
*/
class Solution {
    public String pushDominoes(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        
        int i = n-1;
        while(i >= 0) {
            if(s.charAt(i)=='L') {
                left[i--] = 0;
                int count = 1;
                while(i>=0 && s.charAt(i)=='.') {
                    left[i--] = count++;
                }
            }
            else {
                i--;
            }
        }
        i = 0;
        while(i < n) {
            if(s.charAt(i)=='R') {
                right[i++] = 0;
                int count = 1;
                while(i<n && s.charAt(i)=='.') {
                    right[i++] = count++;
                }
            }
            else {
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k<n; k++) {
            if(left[k] == right[k]) {
                sb.append('.');
            }
            else if(left[k] < right[k]) {
                sb.append('L');
            }
            else {
                sb.append('R');
            }
        }
        
        return sb.toString();
    }
}

393. UTF-8 Validation
https://leetcode.com/problems/utf-8-validation/

/*
->First check the Number of Bytes, change the count value based on the n-byte
->If the Number of Bytes is 1-byte, just simply traverse
*/
class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        
        for(int i : data) {
            if(count == 0) {
                if((i>>5) == 0b110)  count = 1;
                else if((i>>4) == 0b1110) count = 2;
                else if((i>>3) == 0b11110) count = 3;
                else if((i>>7) != 0) return false;
            }
            else {
                if((i>>6) != 0b10) return false;
                count--;
            }
        }
        
        return (count == 0);
    }
}

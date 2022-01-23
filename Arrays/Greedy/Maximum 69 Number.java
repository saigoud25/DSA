1323. Maximum 69 Number
https://leetcode.com/problems/maximum-69-number/

class Solution {
    public int maximum69Number (int num) {
        int temp = num, num_place = 1, add = 0;
        //If temp = 69
        
        while(temp>0)
        {
            int d = temp%10;
            temp /= 10;
            
            if(d == 6)
            {
                add = 3*num_place;  //add = 30
            }
            
            num_place *= 10;
        }
        //69+30 = 99
        return num+add; 
    }
}

2125. Number of Laser Beams in a Bank
https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

/*
->Multiply prev devices count and current devices to get number of lasers
->If the current devices is 0, don't update the prev
*/
class Solution {
    public int numberOfBeams(String[] bank) {
        int count = 0, prev = 0;
        
        for(String s : bank)
        {
            int temp = 0;
            for(char ch : s.toCharArray())
            {
                if(ch=='1')
                {
                    temp++;
                }
            }
            if(temp != 0)
            {
                count += prev*temp;
                prev = temp;
            }
        }
        
        return count;
    }
}

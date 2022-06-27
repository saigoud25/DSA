2315. Count Asterisks
https://leetcode.com/problems/count-asterisks/

/*
->Maintain a flag variable to check '|', if the first '|' it becomes false until the next '|', so we can exclude counting '*' between each pair
*/
class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        boolean flag = true;
        int n = s.length();
        for(int i = 0; i<n; i++)
        {
            if(flag==true && s.charAt(i)=='*')
            {
                count++;
            }
            if(s.charAt(i)=='|')
            {
                flag = !flag;
            }
        }
        return count;
    }
}

682. Baseball Game
https://leetcode.com/problems/baseball-game/

/*
Can be done using Stack or General Array
->If the string is an number simply add it into array and add to sum
->If the String is "D" double the previous value and add it to array and sum
->If the String is "+" add the last to elements and add the new value to array ans sum
->If the String is "C" substract last value from sum and make it 0 in the array
*/
class Solution {
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length]; 
        int pos = 0;
        int sum = 0;
        for(String s : ops)
        {
            if(Character.isDigit(s.charAt(0)) || s.charAt(0)=='-')
            {
                arr[pos] = Integer.parseInt(s);
                sum += arr[pos++];
            }
            else if(s.equals("D"))
            {
                int e = 2*arr[pos-1];
                arr[pos++] = e;
                sum += e;
            }
            else if(s.equals("+"))
            {
                arr[pos] = arr[pos-1]+arr[pos-2];
                sum += arr[pos];
                pos++;
            }
            else
            {
                pos--;
                sum -= arr[pos];
                arr[pos] = 0;
            }
        }
        return sum;
    }
}

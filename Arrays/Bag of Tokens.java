948. Bag of Tokens
https://leetcode.com/problems/bag-of-tokens/

/*
->Sort the Array, 
->If start value is less than power increment score ans decrement power, update the max accordingly
->Else check the score, if score is greater than 0, add the last value to the power, decrement score
->If both are not valid break the loop.
*/
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, max = 0;
        
        int i = 0, j = tokens.length-1;
        
        while(i<=j) {
            if(tokens[i]<=power) {
                power -= tokens[i++];
                score++;
                max = Math.max(max, score);
            } 
            else if(score>0) {
                score--;
                power += tokens[j--];
            }
            else {
                break;
            }
        }
        
        return max;
    }
}

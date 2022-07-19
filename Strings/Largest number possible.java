Largest number possible
https://practice.geeksforgeeks.org/problems/largest-number-possible5028/1

/*
->Using Greedy Approach
->Try to append the maximum digit to the sb, and remove the digit from the S
->Handle the Edge cases
*/
class Solution{
    static String findLargest(int N, int S){
        // code here
        if(S==0 && N!=1 || S>9*N) return "-1";
        if(S<=9 && N==1) return ""+S;
        
        StringBuilder sb = new StringBuilder();
        
        while(S>=0 && sb.length()<N)
        {
            for(int i = 9; i>=0; i--)
            {
                if(S>=i)
                {
                    sb.append(""+i);
                    S -= i;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}

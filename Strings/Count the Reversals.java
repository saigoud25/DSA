Count the Reversals
https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1

/*
->Count the total number of Opened and Closed braces in the end
->If Open braces are 10, then 5 open braces should be reversed to balance same to the Closed ones 
*/

class Sol
{
    int countRev (String s)
    {
        // your code here   
        
        if(s.length()%2 != 0) return -1;
        
        int open = 0, close = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch=='{') {
                open++;
            }
            else if(open>0){
                open--;
            }
            else {
                close++;
            }
        }
        
        return (int)(Math.ceil(open/2.0)+Math.ceil(close/2.0));
    }
}

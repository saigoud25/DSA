Swap bits 
https://practice.geeksforgeeks.org/problems/swap-bits5726/1#
https://youtu.be/5crWUE65q44

/*
https://youtu.be/5crWUE65q44
*/
class Solution{
    
    int swapBits(int x, int p1, int p2, int n)
    {
        /*
        For 47 - 00101111
        a ^ b = c
        b ^ c = a
        a ^ c = b
        
        x = 00101111
        s = 11001100 (c0c0)
        a = 111
        b = 001
        c = 110
        */
        int a = (x>>p1) & (1<<n)-1;
        /*
            A
        1<n-1 = 1000-1 = 0111
        (x>>p1) ->  00010111
        (1<<n)-1 -> 00000111 (and)
                A = 00000111
        */
        int b = (x>>p2) & (1<<n)-1;
        /*
            B
        (x>>p2) ->  00000001
        (1<<n)-1 -> 00000111 (and)
                B = 00000001
        */
        int c = a ^ b;
        /*
        C = 110
        */
        c = (c<<p1) | (c<<p2);
        /*
        (c<<p1) = 00001100
        (c<<p2) = 11000000 (or)
              C = 11001100
        */
        int ans = (x^c);
        /*
        X = 00101111
        C = 11001100 (X^C)
        S = 11100011
        
        */
        // System.out.println(Integer.toBinaryString(ans));
        return ans;
    }
}

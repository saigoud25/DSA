Shop in Candy Store 
https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1#

/*
->Sort the given candies array,
->To get the minimum cost, add starting candies and remove k candies from back
->To get the maximum cost, add ending candies and remove k candies from the front
*/
class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        int min = 0, max = 0;
        int i = 0, pos = N-1;
        Arrays.sort(candies);
        while(i<=pos)
        {
            min += candies[i++];
            pos = pos-K;
        }
        pos = 0; i = N-1;
        while(pos<=i)
        {
            max += candies[i--];
            pos = pos+K;
        }
        return new ArrayList(Arrays.asList(min, max));
    }
}

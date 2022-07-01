1105. Filling Bookcase Shelves
https://leetcode.com/problems/filling-bookcase-shelves/


/*
https://leetcode.com/problems/filling-bookcase-shelves/discuss/1107093/Java-Solution-with-both-recursive-with-memo-plus-Iterative-with-1D-DP

->Using DP
->At each book we have 2 steps
->1. include in the current shelf,
    ->Possible only if remaining shelf width is greater than or equal to present book width
    ->while calling recursion decrement the shelf width with current shelf book width
    ->currHeight(Shelf) would be max of previous book or present book height
->2. include int the next shelf,
    ->It is possible every time
    ->Add the height of present book
    ->while calling the remain shelf width would be present shelf width, pass present book height
*/

class Solution {
    int[][] dp;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length][shelfWidth+1];
        return recursion(0, shelfWidth, shelfWidth, 0, books);
    }
    
    public int recursion(int i, int sw, int remain_sw, int currHeight, int[][] books)
    {
        if(i==books.length) return currHeight;
        
        if(dp[i][remain_sw] != 0) return dp[i][remain_sw];
        
        int includeCurrShelf = Integer.MAX_VALUE;
        
        if(remain_sw >= books[i][0])
        {
            includeCurrShelf = recursion(i+1, sw, remain_sw - books[i][0], Math.max(currHeight, books[i][1]), books);
        }
        
        int includeNewShelf = currHeight + recursion(i+1, sw, sw - books[i][0], books[i][1], books);
        
        return dp[i][remain_sw] = Math.min(includeCurrShelf, includeNewShelf);
    }
}

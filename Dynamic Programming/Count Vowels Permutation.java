1220. Count Vowels Permutation
https://leetcode.com/problems/count-vowels-permutation/

/*
https://youtu.be/O0eJzWLvcbs

->Check the base case,
*/
class Solution {
    HashMap<Character, String> map;
    int mod = 1000000007;
    long[][] dp;
    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        dp = new long[n][26];
        
        map.put('p', "aeiou");
        map.put('a', "e");
        map.put('e', "ai");
        map.put('i', "aeou");
        map.put('o', "iu");
        map.put('u', "a");
        
        long ans = helper(n-1, 'p')%mod;
        // System.out.println(dp[n-1]['p'-'a']);
        return (int)ans;
    }
    
    public long helper(int i, char ch) {
        if(dp[i][ch-'a'] != 0) {
            return dp[i][ch-'a'];
        }
        if(i==0) {
            switch (ch) {
                case 'a' : 
                    return 1;
                case 'e' : 
                    return 2;
                case 'i' : 
                    return 4;
                case 'o' : 
                    return 2;
                case 'u' : 
                    return 1;
                default : 
                    return 5;
            }
        }
        
        long ans = 0l;
        
        for(char c : map.get(ch).toCharArray()) {
            ans += helper(i-1, c)%mod;
        }
        
        dp[i][ch-'a'] = ans;
        
        return ans;
    }
}

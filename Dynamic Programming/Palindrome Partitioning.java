131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/

/*
->Check the Solutions section
*/
class Solution {
    List<List<String>> ans;
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        dp = new boolean[n][n];
        helper(0, s, new ArrayList<String>());
        return ans;
    }
    public void helper(int i, String s, List<String> list) {
        if(i>=s.length()) {
            ans.add(new ArrayList<>(list));
        }
        
        for(int j = i; j<s.length(); j++) {
            if(s.charAt(i)==s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                dp[i][j] = true;
                list.add(s.substring(i, j+1));
                helper(j+1, s, list);
                list.remove(list.size()-1);
            }
        }
    }
}

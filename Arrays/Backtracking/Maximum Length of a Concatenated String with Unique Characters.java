1239. Maximum Length of a Concatenated String with Unique Characters
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

/*
->Using Backtracking, take only uniq strings
*/
class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        if(arr.size()<1) return 0;
        
        dfs(0, arr, "");
        
        return max;
    }
    
    public void dfs(int i, List<String> arr, String s) {
        boolean flag = isUniq(s);
        
        if(flag) {
            max = Math.max(max, s.length());
        }
        
        if(!flag || i==arr.size()) {
            return;
        }

        for(int k = i; k<arr.size(); k++) {
            dfs(k+1, arr, s+arr.get(k));
        }
        
        return;
    }
    
    public boolean isUniq(String s) {
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray()) {
            if(arr[ch-'a'] == 1) {
                return false;
            }
            arr[ch-'a']++;
        }
        
        return true;
    }
}

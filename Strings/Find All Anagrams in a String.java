438. Find All Anagrams in a String
https://leetcode.com/problems/find-all-anagrams-in-a-string/


/*
->Make the frequency array to the p String 
->If the s.charAt(i) present in the frequency arr, check from the i to i+p.length()
->If both arrays are equal add the i to the ans array
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int arr[] = new int[26];
        int n = p.length();
        
        for(int i = 0; i<n; i++) {
            arr[p.charAt(i)-'a']++;
        }
        
        for(int i = 0; i<=s.length()-n; i++) {
            if(arr[s.charAt(i)-'a'] != 0) {
                int[] temp = new int[26];
                
                for(int j = i; j<n+i; j++) {
                    temp[s.charAt(j)-'a']++;
                }
                
                if(Arrays.equals(arr, temp)) {
                    ans.add(i);
                }
            }
        }
        
        return ans;
    }
}

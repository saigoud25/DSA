792. Number of Matching Subsequences
https://leetcode.com/problems/number-of-matching-subsequences/

/*
->Add the words elements in the HashMap along with frequencies
->Traverse the keyset()
->If both characters of S and temp is same, increment both i and j
->Else increment only i
->If the i equal to the length of temp, add the frequncy of temp to the ans
*/
class Solution {  
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for(String i : words) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(String word : map.keySet()) {
            int i = 0;
            int j = 0;
            
            while(i<s.length() && j<word.length()) {
                
                if(s.charAt(i)==word.charAt(j)) {
                    i++;
                    j++;
                }
                else {
                    i++;
                }
                
                if(j==word.length()) {
                    sum += map.get(word);
                }
            }
        }
        
        return sum;
    }

}

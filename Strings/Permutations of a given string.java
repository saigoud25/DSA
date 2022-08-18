Permutations of a given string
https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

/*
->Anuj Bayya video
->Make one place as a constant and swap the both elements
->Instead of swapping, can create both substrings and concatenate both
*/

class Solution {
    HashSet<String> set;
    public List<String> find_permutation(String S) {
        // Code here
        set = new HashSet<>();
        helper(S, "");
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
    void helper(String s, String res) {
        if(s.length()==0) {
            set.add(res);
            return;
        }
        
        for(int k = 0; k<s.length(); k++) {
            char temp = s.charAt(k);
            String left = s.substring(0, k);
            String right = s.substring(k+1);
            
            helper(left+right, res+temp);
        }
        return;
    }
}

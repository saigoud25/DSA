1048. Longest String Chain
https://leetcode.com/problems/longest-string-chain/


/*
->Using Dynamic Programming
->Sort the words array based on the length
->Insert the Strings into hashmap
->Find the chain for the 1st element in the words

->TO find the chain
    ->Find the max of all permutation chain + 1
    ->Update hashmap values each time we get the chain
*/
class Solution {
    HashMap<String, Integer> map;
    public int longestStrChain(String[] words) {
        map = new HashMap<>();
        Arrays.sort(words, (a, b) -> b.length()-a.length());
        
        for(String s : words)
        {
            map.put(s, 0);
        }
        int max = 1;

        for(String s : words)
        {
            if(map.get(s) == 0)
            {
                max = Math.max(max, helper(s));
            }
        }

        return max;
    }
    int helper(String s)
    {
        if(!map.containsKey(s))
        {
            return 0;
        }
        if(s.length()==1)
        {
            return 1;
        }
        if(map.get(s) != 0) return map.get(s);
        
        int ans = 0;
        for(int i = 0; i<s.length(); i++)
        {
            String str = s.substring(0, i)+s.substring(i+1);
            ans = Math.max(ans, helper(str)+1);
        }
        map.put(s, ans);
        
        return ans;
    }
}

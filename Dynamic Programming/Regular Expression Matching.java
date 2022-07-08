10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/

/*
https://youtu.be/HAA8mgxlov8
->If '*' occured we havw two options increment i by 1, or increment j by 2
*/
class Solution {
    HashMap<String, Boolean> dp;
    public boolean isMatch(String s, String p) {
        dp = new HashMap<>();
        return func(0, 0, s, p);
    }
    boolean func(int i, int j, String s, String p)
    {
        if(i>=s.length() && j>=p.length()) return true;
        
        String key = i+""+j;
        if(dp.containsKey(key)) return dp.get(key);
        
        if(j>=p.length()) return false;
        
        boolean flag = false;
        
        if(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) 
        {
            flag = true;
        }
        
        if((j+1) < p.length() && p.charAt(j+1)=='*')
        {
            boolean temp = (func(i, j+2, s, p) || (flag && func(i+1, j, s, p)));
            dp.put(key, temp);
            return temp;
        }
        
        if(flag) 
        {
            boolean temp = func(i+1, j+1, s, p);
            dp.put(key, temp);
            return temp;
        }
        
        dp.put(key, false);
        return false;
    }
}

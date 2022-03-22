17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/*
->Map characters to numbers and store in HashMap
->add an character and increment i, call recursion function
->""+a, ""+b, ""+c, 
->"a"+d, "a"+e, "a"+f.....
->If i equals to length of digits, add string(s) to arr
*/
class Solution {
    ArrayList<String> arr;
    HashMap<Character, ArrayList<Character>> hm;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return (new ArrayList<String>());
        arr = new ArrayList<>();
        hm = new HashMap<>();
        hm.put('2', new ArrayList(Arrays.asList('a', 'b', 'c')));
        hm.put('3', new ArrayList(Arrays.asList('d', 'e', 'f')));
        hm.put('4', new ArrayList(Arrays.asList('g', 'h', 'i')));
        hm.put('5', new ArrayList(Arrays.asList('j', 'k', 'l')));
        hm.put('6', new ArrayList(Arrays.asList('m', 'n', 'o')));
        hm.put('7', new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        hm.put('8', new ArrayList(Arrays.asList('t', 'u', 'v')));
        hm.put('9', new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        
        helper("", digits, 0);
        
        return arr;
    }
    void helper(String s, String digits, int i)
    {
        if(i==digits.length() )
        {
            arr.add(s);
            return;
        }
        for(Character ch : hm.get(digits.charAt(i)))
        {
            helper(s+ch, digits, i+1);
        }
        return;
    }
}

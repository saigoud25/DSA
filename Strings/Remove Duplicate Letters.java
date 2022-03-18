316. Remove Duplicate Letters
https://leetcode.com/problems/remove-duplicate-letters/
https://youtu.be/muDlIlVE1q4

/*
https://youtu.be/muDlIlVE1q4
->Add character into stack, remove previous if they are greater than ch and they have last visited index is greater than present
->After adding, mark it as checked
->Convert stack into StringBuilder and Reverse 
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack();
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> check = new HashMap<>();
        int[] A = new int[26];
        for(int i = 0; i<s.length(); i++)
        {
            hm.put(s.charAt(i), i);
            check.put(s.charAt(i), 0);
        }

        st.push(s.charAt(0));
        check.put(s.charAt(0), 1);
        for(int i = 1; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(check.get(ch)==1) continue;
            while(!st.isEmpty() && st.peek()>ch && i-1<hm.get(st.peek()))
            {
                check.put(st.peek(), 0);
                st.pop();
            }
            st.push(ch);
            check.put(ch, 1);
                
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty())
        {
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
}

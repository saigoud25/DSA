2325. Decode the Message
https://leetcode.com/problems/decode-the-message/

/*
->Iterate through the key and add the characters to the hashmap
->From hashmap retrive the message characters and append to the StringBuilder
*/
class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        int i = 97;
        for(String ch : key.split(""))
        {
            char c = ch.charAt(0);
            // System.out.println(c);
            if(c != ' ' && !map.containsKey(c))
            {
                char a = (char)i++;
                map.put(c, a);
                // System.out.println(i);
            }
        }
        map.put(' ', ' ');
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k<message.length(); k++)
        {
            char ch = message.charAt(k);
            sb.append(map.get(ch));
        }
        // System.out.println(map);
        return sb.toString();
    }
}

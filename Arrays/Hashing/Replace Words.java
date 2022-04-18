/*
648. Replace Words
https://leetcode.com/problems/replace-words/submissions/

->Using HashSet, add dictionary values into set
->Traverse the sentence, split the sentence by (" ")
    ->Traveser each word in a sentence
    ->Check the substring of word contains in the set, if yes break the loop
    ->append the final substring to the StringBuilder
*/

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(String s : dictionary) set.add(s);
        
        for(String word : sentence.split(" "))
        {
            String temp = "";
            for(int i = 1; i<=word.length(); ++i)
            {
                temp = word.substring(0, i);
                if(set.contains(temp)) break;
            }
            sb.append(temp+" ");
        }
        
        return sb.toString().substring(0, sb.length()-1);
    }
}

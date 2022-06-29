211. Design Add and Search Words Data Structure
https://leetcode.com/problems/design-add-and-search-words-data-structure/

/*
->Same as Implementation of Trie problem
->If '.' occured, go and search for each non-empty index in a node.links array using recursion
*/
class TrieNode 
{
    TrieNode[] links = new TrieNode[26];
    boolean flag = false;
    
    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
    
    void put(char ch, TrieNode node)
    {
        links[ch - 'a'] = node;
    }
    
    TrieNode get(char ch)
    {
        return links[ch - 'a'];
    }
    
    void setEnd()
    {
        flag = true;
    }
    
    boolean isEnd()
    {
        return flag;
    }
}

class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        
        for(char ch : word.toCharArray())
        {
            if(!node.containsKey(ch))
            {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    public boolean search(String word) {
        
        return helper( word, root);
    }
    
    public boolean helper(String word, TrieNode node)
    {
        if(word.equals("")) return node.isEnd();
        char ch = word.charAt(0);
        if(ch == '.')
        {
            boolean flag = false;
            for(TrieNode x : node.links)
            {
                if(x != null)
                {
                    flag = helper(word.substring(1), x);
                }
                
                if(flag) return true;
            }
            
            return false;
        }
        
        if(node.containsKey(ch))
        {
            return helper(word.substring(1), node.get(ch));
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

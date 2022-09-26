990. Satisfiability of Equality Equations
https://leetcode.com/problems/satisfiability-of-equality-equations/

/*
->First Union the all equal equations
->In next iteration check the parents of not equal equations
*/
class Solution {
    int[] parent;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for(int i = 0; i<26; i++) {
            parent[i] = i;
        }
        for(String s : equations) {
            if(s.charAt(1)=='=') {
                union(s.charAt(0)-'a', s.charAt(3)-'a');
            }
        }
                
        for(String s : equations) {
            if(s.charAt(1)=='!') {
                if(find(parent[s.charAt(0)-'a']) == find(parent[s.charAt(3)-'a'])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int find(int node) {
        while(parent[node] != node) {
            node = parent[node];
        }
        
        return node;
    }
    
    public void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);
        
        if(iRoot <= jRoot) {
            parent[jRoot] = iRoot;
        } else {
            parent[iRoot] = jRoot;
        }
    }
}

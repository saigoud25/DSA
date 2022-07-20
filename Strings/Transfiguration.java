Transfiguration
https://practice.geeksforgeeks.org/problems/b6b3297ccfb1ad5f66a9c2b92979170417adf114/1

/*
->Check whether two strings are valid strings using HashMaps
->Use equals() when comparing two objects like Integers, (==) failed here
->Traverse from back side of two strings
->If both characters are equal decrement i and j
->Else decrement only i, and increment count. Return the Count
*/
class Solution
{
    int transfigure (String A, String B)
    {
    	// Your code goes here.
    	if(A.length() != B.length()) return 0;
    	
    	int count = 0, i = A.length()-1, j = B.length()-1;
    	
    	HashMap<Character, Integer> map1 = new HashMap<>();
    	HashMap<Character, Integer> map2 = new HashMap<>();
    	
    	for(Character ch : A.toCharArray()) {
    	    map1.put(ch, map1.getOrDefault(ch, 0)+1);
    	}
    	
    	for(Character ch : B.toCharArray()) {
    	    map2.put(ch, map2.getOrDefault(ch, 0)+1);
    	}
    	
    	for(Character ch : map1.keySet()) {
    	    if(!map1.get(ch).equals(map2.get(ch))) {
    	        return -1;
    	    }
    	}
    	
    	while(i>=0) {

    	    if(A.charAt(i) == B.charAt(j)) {
    	        j--;
    	    }
    	    else {
    	        count++;
    	    }
    	    i--;
    	}
    	
    	return count;
    }
}

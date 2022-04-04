Previous number in one swap
https://practice.geeksforgeeks.org/problems/previous-number-in-one-swap5707/1#


/*
->Using TreeSet and HashMap
->Our target is to find the higher of the element and swap both characters
->Here check the character have lower value from back side, if yes swap the character
    with the lower charcter index which was stored in the hashmap
->If no lower element found, simply add the character into treeset and hashmap index as value
*/
//User function Template for Java
class Solution{
    static String previousNumber(String S){
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        TreeSet<Character> set = new TreeSet<>();
        char[] arr = S.toCharArray();
        int n = arr.length;
        
        for(int i = n-1; i>=0; i--)
        {
            Character ch = set.lower(arr[i]);
            
            if(ch != null)
            {
                if(i == 0 && ch == '0') return "-1";
                
                char temp = arr[i];
                arr[i] = arr[map.get(ch)];
                arr[map.get(ch)] = temp;
                
                return new String(arr);
            }
            
            set.add(arr[i]);
            map.put(arr[i], i);
        }
        
        return "-1";
    }
}

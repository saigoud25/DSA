179. Largest Number
https://leetcode.com/problems/largest-number/


/*
->Convert the nums int array to arr String array
->Sort the arr based on the comparator reverse Order, for this concatinate two strings and then compare
->If the arr contains all zero's then return the single "0" as the ans
->Convert the String as a single String and return it
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i<nums.length; i++)  arr[i] = ""+nums[i];
        Arrays.sort(arr, (a, b) -> {
            String s1 = a+b;
            String s2 = b+a;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        
        if(arr[0].equals("0")) return "0";
        for(String s : arr) sb.append(s);
        return sb.toString();
    }
}

1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/


/*
->Use hashMaps to store the square values
->Using two pointer methods find the product of two numbers in present in the map
->If contains add it's frequency to the count
->Do this for both arrays
*/
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i : nums1) {
            long ele = (long)i*i;
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int i = 0; i<nums2.length-1; i++) {
            for(int j = i+1; j<nums2.length; j++) {
                long ele = (long)nums2[i]*nums2[j];
                if(map.containsKey(ele)) {
                    count += map.get(ele);
                }
            }
        }
        map.clear();
        
        for(int i : nums2) {
            long ele = (long)i*i;
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        for(int i = 0; i<nums1.length-1; i++) {
            for(int j = i+1; j<nums1.length; j++) {
                long ele = (long)nums1[i]*nums1[j];
                if(map.containsKey(ele)) {
                    count += map.get(ele);
                }
            }
        }
        
        return count;
    }
}

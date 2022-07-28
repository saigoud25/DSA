152. Maximum Product Subarray
https://leetcode.com/problems/maximum-product-subarray/

/*
->Traverse from front and back side while traversing calculate the product
->When the array has even positive negative integers the product will be the product of all elements
->When the array has odd positive negative integers 
    ->Eg, 1,2,-3,-4,-5,6
    ->We just have to divide the elements into two parts, last negative numbers will be the splitting point
    ->when splitted at -3, (1,2) and (-4,-5,6)
    ->when splitted ad -5, (1,2,-3,-4) and (-5,6)
*/
class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, prod1 = 1, prod2 = 1, n = nums.length;
        
        for(int i = 0; i<n; i++) {
            prod1 *= nums[i];
            prod2 *= nums[n-(i+1)];
            if(prod1 > prod2) {
                ans = Math.max(prod1, ans);
            }
            else {
                ans = Math.max(prod2, ans);
            }
            if(prod1==0) prod1 = 1;
            if(prod2==0) prod2 = 1;
        }

        return ans;
    }
}

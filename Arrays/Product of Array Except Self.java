238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/

/*
Method-1:
->Traverse array and find product of total array
->update array[i] = product/array[i]
Method-2:
->Fill left array by traversing from left and by multipliying left element
->Fill right array by traversing from right and by multiplying right element
->Now fill product[i] array by multiplying left[i]*right[i]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Method-2
        int len = nums.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int product[] = new int[len];
        
        left[0] = 1;
        right[len-1] = 1;
        
        for(int i = 1; i<len; i++)
            left[i] = left[i-1] * nums[i-1];
            
        for(int i = len-2; i>=0; i--)
            right[i] = right[i+1] * nums[i+1];       
        
        for(int i = 0; i<len; i++)
            product[i] = left[i] * right[i];
               
        return product;
    }
}

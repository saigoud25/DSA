4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/
https://youtu.be/NTop3VTjmxk


/*
https://youtu.be/NTop3VTjmxk
->Use Binary Search on lowest length array
->Divide the arrays in two cuts, check if the cuts are valid or not
->If cuts are valid, return the median values by those cuts
->To check cuts are valid:
    ->The value of left1 should less than the right2 and
    ->The value of left2 should less than the right1
->If left1 is greater than right2, decrement left1 position
->If left2 is greater than right1, decrement left1 position 
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length, n2 = nums2.length; 
        int low = 0, high = n1;
        
        while(low<=high) 
        {
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2 - cut1;
            
            int l1 = (cut1==0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2==0) ? Integer.MIN_VALUE : nums2[cut2-1];
            
            int r1 = (cut1==n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2==n2) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2 == 0)
                {
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                }
                else
                {
                    return (Math.max(l1, l2));
                }
            }
            else if(l1 > r2)
            {
                high = cut1 - 1;
            }
            else
            {
                low = cut1 + 1;
            }
        }
        
        return 0;
    }
}

215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/

/*
Method-1: Use QickSort Algorithm Technique to return kth largest element
Method-2: Use Arrays.sort()/Collections.sort() and last-k index
Method-3: Use PriorityQueue(reverseOrder) and return kth element
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
    //Method-2
        Arrays.sort(nums);
        return nums[nums.length-k];
    //Method-3
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) pq.add(i);
        int len = nums.length;
        int i = 0;
        while(i<len)
        {
            if(i==k-1) return pq.peek();
            pq.poll();
            i++;
        }
        return 0;
    }
}

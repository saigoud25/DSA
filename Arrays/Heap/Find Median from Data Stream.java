295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/

/*
->Using Two PriorityQueues
->First directly add the element into max heap, and poll the max heap and add it to the min heap
->Make Sure that the size of max heap should be always greater or equal to the size of min heap4
->If the size of min heap is greater poll an element and add it to the max heap

->While finding the median
->If the elements are even, i.e., if both heaps are equal size, return average of both heap top values
->Else, return the peek value of max heap
*/
class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        
        if(max.size() < min.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(min.size()==max.size()) {
            return (min.peek()+max.peek())/2.0;
        }
        else {
            return (double) max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

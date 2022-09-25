622. Design Circular Queue
https://leetcode.com/problems/design-circular-queue/

class MyCircularQueue {
    int[] arr;
    int size, front, rear;
    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        size = 0; front = 0; rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()) {
            arr[rear++] = value;
            if(rear==arr.length) {
                rear = 0;
            }
            
            size++;
            return true;
        }
        
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()) {
            arr[front++] = -1;
            if(front==arr.length) {
                front = 0;
            }
            
            size--;
            return true;
        }
        
        return false;
    }
    
    public int Front() {
        return arr[front];
    }
    
    public int Rear() {
        if(rear==0) {
            return arr[arr.length-1];
        }
        return arr[rear-1];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==arr.length;
    }
}

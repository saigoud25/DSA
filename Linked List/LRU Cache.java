146. LRU Cache
https://leetcode.com/problems/lru-cache/

/*
->Using doubly linked list
->Each node contains key, value, next and prev pointers
->Add every node at the begining of the list
->Remove from the end of the list
->If the node is used, remove that and add again at the beginning
->Maintain a HashMap, key as a key and Node as a value
->When removed from linked list remove from map
*/
class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key, val;
        
        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int size = 0;
    int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n==null) return -1;

        remove(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n==null)
        {
            n = new Node(key, value);
            map.put(key, n);
            size++;
            add(n);
        }
        else
        {        
            n.val = value;
            remove(n);
            add(n);
        }
        if(size>cap)
        {
            map.remove(tail.prev.key);
            remove(tail.prev);
            size--;
        }
    }
    
    void add(Node node)
    {
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    
    void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

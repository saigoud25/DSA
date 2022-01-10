//Singly Linked List Implementation (Java)
//check ( https://www.jdoodle.com/online-java-compiler/ ) & Login to Run Code

public class LinkedList {
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String args[])
    {
      LinkedList list = new LinkedList();
      list.head = new Node(10);
      Node n2 = new Node(20);
      Node n3 = new Node(30);
      Node n4 = new Node(40);
      
      list.head.next = n2;
      n2.next = n3;
      n3.next = n4;
      
      list = add(list, 50);
      list = add(list, 60);
      list = add(list, 70);
      
      while(list.head != null)
      {
          System.out.println(list.head.data);
          list.head = list.head.next;
      }
      
    }
    
    static LinkedList add(LinkedList list, int data)
    {
        Node temp = new Node(data);   
        
        Node last = list.head;
        while(last.next != null)
        {
          last = last.next;
        }
        
        last.next = temp;

        return list;
    }
}

Output:
10
20
30
40
50
60
70

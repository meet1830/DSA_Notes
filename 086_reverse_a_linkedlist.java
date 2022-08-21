public class LinkedList {
  static class Node {
    // define terms
    int value;
    Node next;
    
    // constructor
    public Node(int value) {
      this.value = value;
      this.next = next;
    }
  }
  
  static Node head;
  
  public static void printList() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.value + " ");
      temp = temp.next;
    }
    System.out.println();
  } 
  
  public static void reverseList() {
    Node prev = null, current = head, next = null;
    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.head = new Node(2);
    list.head.next = new Node(3);
    list.head.next.next = new Node(4);
    list.head.next.next.next = new Node(6);
    list.printList();
    list.reverseList();
    list.printList();
  }
}

// output -> 6 4 3 2

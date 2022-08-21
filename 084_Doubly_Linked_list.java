package DLL_2;

public class DLL_1_list {
  private Node head;
  private class Node {
    int value;
    Node next;
    Node prev;

    public Node (int value) {
      this.value = value;
    }
    public Node (int value, Node next, Node prev) {
      this.value = value;
      this.next = next;
      this.prev = prev;
    }
  }



  public void printList() {
    Node temp = head;
    Node last = null;
    while (temp != null) {
      System.out.print(temp.value + " ");
      // last will point to the last node at the end of loop
      last = temp;
      temp = temp.next;
    }
    System.out.println(); 
    
    while (last != null) {
      System.out.print(last.value + " ");
      last = last.prev;
    }
    System.out.println(); 
  } 



  // public void printReverse() {
    // traverse through to the last node and then print using another while loop
  // }



  public void insertFirst (int val) {
    Node node = new Node(val);
    node.next = head;
    node.prev = null;
    // if condition when this is the first element inserted
    if (head != null) {
      head.prev = node;
    }
    head = node;
  }



  public void insertLast(int val) {
    Node node = new Node(val);
    Node last = head;
    node.next = null;
    // edge case
    if (head == null) {
      node.prev = null;
      head = node;
      // OR
      // insertFirst(val);
      return;
    }
    while (last.next != null) {
      last = last.next;
    }
    node.prev = last;
    last.next = node;
  }



  public void insert(int val, int index) {
    // edge case -> insert in empty list
    Node node = new Node(val);
    if (head == null) {
      node.next = null;
      node.prev = null;
      head = node;
      return;
    }

    // edge case -> insert at first 
    if (index == 0) {
      // insertFirst(val);
      node.next = head;
      node.prev = null;
      if (head != null) {
        head.prev = node;
      }
      head = node;
      return;
    }

    // edge case -> insert at last 
    Node last = head;
    int size = 1;
    while (last.next != null) {
      last = last.next;
      size++;
    }
    if (index >= size) {
      // insertLast(val);
      node.prev = last;
      node.next = null;
      last.next = node;
      return;
    }

    // insert anywhere in middle
    Node temp = head;
    for (int i=1; i<index; i++) {
      temp = temp.next;
    }
    Node nodeMiddle = new Node(val, temp.next, temp);
    temp.next.prev = nodeMiddle;
    temp.next = nodeMiddle;
  }



  // find function
  public Node findNode (int val) {
    Node find = head;
    while (find != null) {
      if (find.value == val) {
        return find;
      }
      find = find.next;
    } 
    return null;
  }



  // ALWAYS START ASSIGNING POINTERS FROM THE RIGHT ELEMENTS TO AVOID OVERLAPPING



  // INSERT A NODE AFTER THE GIVEN NODE
  public void insertAfter(int after, int val) {
    Node previous = findNode(after);
    if (previous == null) {
      System.out.println("Does not exist");
      return;
    }
    Node node = new Node(val);
    // edge case -> null pointer exception
    if (previous.next != null) {
      node.next = previous.next;
      node.next.prev = node;
    }
    previous.next = node;
    node.prev = previous;
  }

}

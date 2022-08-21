package CLL_3;

public class CLL_list {
  private class Node {
    int value;
    Node next;
    
    //constructor
    public Node (int value) {
      this.value = value;
    }
    
  }

  private Node head;
  private Node tail;

  //constructor
  public CLL_list() {
    this.head = head;
    this.tail = tail;
  }



  public void printList() {
    Node temp = head;
    if (head == null) {
      return;
    }

    do {
      System.out.print(temp.value + " ");
      temp = temp.next;
    } while (temp != head);

    System.out.println();
  }

  

  // function to get size of list
  public int getSize() {
    Node node = head;
    int size = 1;

    // edge case -> list empty
    if (head == null) {
      return 0;
    }

    //get size
    if (node.next != null) {
      size++;
    }
    node = node.next;
    while (node != head) {
      node = node.next;
      size++;
    }
    System.out.println(size);
    return size;
  }



  public void insertLast(int val) {
    Node node = new Node(val);
    // edge case -> list empty
    if (head == null) {
      head = node;
      tail = node;
    }
    tail.next = node;
    node.next = head;
    tail = node;
  }



  public void delete (int val) {
    Node del = head;
    // edge case -> list empty
    if (del == null) {
      return;
    }
    // edge case -> head is to be deleted
    if (head.value == val) {
      head = head.next;
      tail.next = head;
      return;
    }

    Node node = head;
    do {
      del = node.next;
      if (del.value == val) {
        node.next = del.next;
        break;
      }
      node = node.next;
    } while (node != head);

  }

}

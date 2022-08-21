// import java.util.LinkedList;

package LL_1;

public class LL_1_list {
  /* public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(32);
  } */


  private class Node {
    private int value;
    private Node next;
    // reference variable
  
    // constructors
    public Node(int value) {
      this.value = value;
    }

    public Node (int value, Node next) {
      this.value = value;
      this.next = next;
    }
  
  }

  private Node head;
  private Node tail;
  public int size;
  // by default value is null
  
  // constructor
  public LL_1_list() {
    this.size = 0;
  }

  



  // INSERT ELEMENT AT FIRST POSITION
  // ALSO WORKS WHEN SIZE OF LIST = 0 (FIRST ELEMENT ADDED)
  public void insertFirst(int val) {
    // create a new node 
    Node node = new Node(val);
    // point it to head
    node.next = head;
    // make it head
    head = node;

    // if size is initially zero or there is no element in the list, then tail by default will be pointing to nul but head and tail should be same
    // hence
    if (tail == null) {
      tail = head;
    }

    // increment the size by one 
    // size is optional but if we want to know the size after wards then we have to traverse the list which is O(n).
    size++;
  }



  // PRINT LIST
  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " ");
      temp = temp.next;
    }
    System.out.println("");
  }



  // INSERT AT LAST POSITION
  public void insertLastWithTail(int val) {
    // What if the list is empty, then it will throw an error as tail is null
    // not tail.next == null
    if (tail == null) {
      insertFirst(val);
      return;
    }
    // create node
    Node node = new Node(val);
    // point tail to this node
    tail.next = node;
    // update tail value
    tail = node;

    //increment size
    size++;
  }

  // what if tail is not maintained or defined
  // then insert at last position
  public void insertLast(int val) {
    // if size is 0
    if (tail == null) {
      insertFirst(val);
      return;
    }
    Node last = head;
    while(last.next != null) {
      last = last.next;  
    }
    Node node = new Node(val);
    last.next = node;
    tail = node;
    size++;
  }



  // INSERT AT ANY INDEX
  public void insert(int val, int index) {
    // if size is 0 then same case as insertFirst
    if (index == 0) {
      insertFirst(val);
      return;
    }
    // if size is same as index means insert at last position
    if (index == size) {
      insertLast(val);
      return;
    }

    Node temp = head;
    // i=1 cause 0 is first if condition
    for (int i=1; i<index; i++) {
      temp = temp.next;
    } 
    Node node = new Node(val, temp.next);
    // second argument is pasing the next value for the current node which is temp
    // temp.next means created node will point to the next element of temp
    temp.next = node;

    size++;
  }



  // DELETE FIRST ELEMENT
  public int deleteFirst() {
    // storing the value that is being deleted
    int val = head.value;
    head = head.next;
    // if after this the list becomes empty
    if (head == null) {
      tail = null;
    }
    size--;
    return val;
  }



  // function to return reference pointer uptill that node
  public Node getNode(int index) {
    Node node = head;
    for (int i=0; i<index; i++) {
      node = node.next;
    }
    return node;
  }



  // DELETE LAST ELEMENT
  public int deleteLast() {
    if (size <= 1) {
      return deleteFirst(); 
    }
    // get reference variable to second last element
    Node secondLast = getNode(size - 2);

    int val = tail.value;
    tail = secondLast;
    tail.next = null;
    size--;

    return val;
  }



  public int delete(int index) {
    if (index == 0) {
      return deleteFirst();
    }
    if (index == size) {
      return deleteLast();
    }

    // get node uptill the node to be deleted
    Node prev = getNode(index - 1);
    int val = prev.next.value;
    prev.next = prev.next.next;
    size--;
    return val;
  }



  // RETURN NODE FOR THE VALUE PASSED
  public Node findNode(int val) {
    Node node = head;
    while (node != null) {
      if (node.value == val) {
        return node;
      }
      node = node.next;
    }
    return node; 
    // node is null here so return null will be same
  }



  // INSERT NEW ELEMENT AT GIVEN INDEX RECURSIVELY
  public void insertRec(int val, int index) {
    head = insertRec(val, index, head);
  }
  private Node insertRec(int val, int index, Node node) {
    if (index == 0) {
      Node temp = new Node(val, node);
      size++;
      return temp;
    }
    node.next = insertRec(val, index--, node.next);
    return node;
  }

}

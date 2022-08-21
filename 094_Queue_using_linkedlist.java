// implementation of queue using linkedlist
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Queue q = new Queue();
    System.out.println(q.dequeue());
    q.enqueue(10);
    System.out.println(q.dequeue());
    q.enqueue(20);
    q.enqueue(30);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }
}

/*
class Queue {
  linkedList list = new linkedList();
  
  boolean isEmpty() {
    return list.head == null;
  }
  
  void enqueue(int value) {
    list.insertLast(value);
  }
  
  int dequeue() {
    if(isEmpty()) {
      System.out.println("Stack underflow error!");
      return Integer.MIN_VALUE;
    }
    return list.deleteHead();
  }
}
*/

// if using this queue class then no need for linkedlist class
class Queue {
  Node front, rear;
  
  void enqueue(int value) {
    Node add = new Node(value);
    if(rear == null || front == null) {
      front = add;
      rear = add;
      return;
    }
    rear.next = add;
    rear = rear.next;
  }
  
  int dequeue() {
    if(front == null) {
      System.out.println("Queue underflow error!");
      return Integer.MIN_VALUE;
    }
    int delValue = front.value;
    front = front.next;
    return delValue;
  }
}

class Node {
  int value;
  Node next;
  Node(int value) {
    this.value = value;
  }
}

/*
class linkedList {
  Node head;
  
  void insertLast(int value) {
    if(head == null) {
      head = new Node(value);
      return;
    }
    Node addLast = head;
    while(addLast.next != null) {
      addLast = addLast.next;
    }
    addLast.next = new Node(value);
  }
  
  int deleteHead() {
    if(head == null) {
      return Integer.MIN_VALUE;
    }
    else if(head.next == null) {
      int delValue = head.value;
      head = null;
      return delValue;
    }
    else {
      int delValue = head.value;
      head = head.next;
      return delValue;
    }
  }
  
  void printList() {
    if(head != null) {
      Node print = head;
      while(print != null) {
        System.out.print(print.value + " ");
        print = print.next;
      }
      System.out.println();
    }
  }
}
*/

// output
/*
Queue underflow error!
-2147483648
10
20
30
Queue underflow error!
-2147483648
*/

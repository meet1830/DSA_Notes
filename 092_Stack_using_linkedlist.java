// stack implementation using linked list
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Stack st = new Stack();
    System.out.println(st.pop());
    st.push(10);
    System.out.println(st.peek());
    st.push(20);
    st.push(30);
    st.push(40);
    System.out.println(st.pop());
  }
}

class Stack {
  linkedList list = new linkedList();

  boolean isEmpty() {
    return list.head == null;
  }
  
  // isFull does apply for linked list
  
  void push(int value) {
    list.insertFirst(value);
  }
  
  int pop() {
    if(isEmpty()) {
      System.out.println("Stack Underflow error!");
      return Integer.MIN_VALUE;
    }
    return list.deleteHead();
  }
  
  int peek() {
    if(isEmpty()) {
      System.out.println("Stack Underflow error!");
      return Integer.MIN_VALUE;
    }
    return list.head.value;
  }
}

class Node {
  int value;
  Node next;
  Node(int value) {
    this.value = value;
  }
}

class linkedList {
  Node head;
  
  void insertFirst(int value) {
    if(head == null) {
      head = new Node(value);
      return;
    }
    Node addFirst = new Node(value);
    addFirst.next = head;
    head = addFirst;
  }
  
  void printList() {
    if(head != null) {
      Node temp = head;
      while(temp != null) {
        System.out.print(temp.value + " ");
        temp = temp.next;
      }
      System.out.println();
    }
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
}

// output
/*
Stack Underflow error!
-2147483648
10
40
*/

/*
Merge Sort on Doubly Linked List
Given a doubly linked list of N nodes, the task is to sort the given doubly linked list using Merge Sort in both non-decreasing order.

Input
The first line inputs N ,the size of the linked list.
The second line inputs the value of N nodes of the linked list.

Constraints:
1 <= N <= 10^5

Output
Print the linked list in sorted order using Merge Sort in a new line.

Example
Input:
8
7 3 5 2 6 4 1 8
Output:
1 2 3 4 5 6 7 8
*/

// merge sort on doubly linked list
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();
    linkedList list = new linkedList();
    for (int i = 0; i < size; i++) {
      list.insertLast(input.nextInt());
    }
    list.head = list.mergeSort(list.head);
    list.printList();
  }
}

class Node {
  int value;
  Node next, prev;

  Node(int value) {
    this.value = value;
  }
}

class linkedList {
  Node head;

  void insertLast(int value) {
    if (head == null) {
      head = new Node(value);
      return;
    }
    Node addLast = head;
    while (addLast.next != null) {
      addLast = addLast.next;
    }
    addLast.next = new Node(value);
    addLast.next.prev = addLast;
  }

  void printList() {
    if (head != null) {
      Node print = head;
      while (print != null) {
        System.out.print(print.value + " ");
        print = print.next;
      }
      System.out.println();
    }
  }

  Node mergeSort(Node head) {
    if (head.next == null) {
      return head;
    }
    Node mid = findMid(head);
    Node head2 = mid.next;
    mid.next = null;
    Node newHead1 = mergeSort(head);
    Node newHead2 = mergeSort(head2);
    Node finalHead = merge(newHead1, newHead2);
    return finalHead;
  }

  Node findMid(Node head) {
    Node fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  Node merge(Node first, Node second) {
    // If first linked list is empty
    if (first == null) {
      return second;
    }
    // If second linked list is empty
    if (second == null) {
      return first;
    }
    // Pick the smaller value
    if (first.value < second.value) {
      first.next = merge(first.next, second);
      first.next.prev = first;
      first.prev = null;
      return first;
    } else {
      second.next = merge(first, second.next);
      second.next.prev = second;
      second.prev = null;
      return second;
    }
  }
}
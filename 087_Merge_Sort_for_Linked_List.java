/*
Merge Sort for Linked List

Given a linked list of N nodes, the task is to sort the given linked list using Merge Sort.

Input
The first line inputs N ,the size of the linked list.
The second line inputs the value of N nodes of the linked list.

Constraints:
1 <= N <= 10^5

Output
Print the linked list in sorted order using Merge Sort in a new line.

Example
Input:
5
3 5 2 4 1
Output:
1 2 3 4 5

*/



// merge sort a singly linked list
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();
    linkedList list1 = new linkedList();
    for(int i = 0; i < size; i++) {
      list1.insertLast(input.nextInt());
    }
    linkedList result = new linkedList();
    // or can use on same input list1
    result.head = list1.mergeSort(list1.head);
    result.printList();
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
  
  Node mergeSort(Node head) {
    // base case
    if(head.next == null) {
      return head;
    }
    // find mid
    Node mid = findMid(head);
    Node head2 = mid.next;
    mid.next = null;
    Node newHead1 = mergeSort(head);
    Node newHead2 = mergeSort(head2);
    Node finalHead = merge(newHead1, newHead2);
    return finalHead;
  }
  
  Node findMid(Node head) {
    // using fast and slow pointer method also called hare and tortoise method
    Node slow = head, fast = head;
    while(fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next; 
    }
    return slow;
  }
  
  // iterative
  private ListNode merge(ListNode head1, ListNode head2) {
     ListNode saveHead = new ListNode(-1), temp = saveHead;
     while (head1 != null && head2 != null) {
         if (head1.val < head2.val) {
             temp.next = head1;
             head1 = head1.next;
         } else {
             temp.next = head2;
             head2 = head2.next;
         }
         temp = temp.next;
     }
     temp.next = (head1 == null) ? head2 : head1;
     return saveHead.next;
  }
  
  // recursive
  Node merge(Node head1, Node head2) {
  	// If first linked list is empty
  	if (head1 == null) {
      return head2;
    }
    // If second linked list is empty
    if (head2 == null) {
      return head1;
    }
   	// Pick the smaller value
    if (head1.value < head2.value) {
      head1.next = merge(head1.next, head2);
      return head1;
    } 
    else {
      head2.next = merge(head1, head2.next);
      return head2;
    }
  }
}


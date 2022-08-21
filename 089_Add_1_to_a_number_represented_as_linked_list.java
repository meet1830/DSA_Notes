/*
Add 1 to a number represented as linked list

Given a number N, you have to represent it in Linked List such that each digit corresponds to a node in linked list. After forming the linked list, you have to add 1 to last node and then print the updated linked list.

Input
The line inputs N ,an integer.

Constraints:
1 ≤ N < 10^9

Output
Print the updated linked list in new line.

Example
Input:
456
Output:
4 5 7

*/


import java.util.*;

class Node {
  int value;
  Node next;
  Node(int value) {
    this.value = value;
  }
}
  
class linkedList {
  Node head;
  
  void insert(int value) {
    if(head == null) {
      head = new Node(value);
      return;
    }
    Node add = head;
    while(add.next != null) {
      add = add.next;
    }
    add.next = new Node(value);
  }
  
  void printList(Node last) {
    // print in reverse
    if(last.next != null) {
      printList(last.next);
    }
    System.out.print(last.value + " ");
  }
  
}
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    linkedList in = new linkedList(), result = new linkedList();
    int temp = n;
    while(temp > 0) {
      in.insert(temp % 10);
      temp /= 10;
    } 
    // carry initialized as 1 to add 1 to number
    int carry = 1; 
    Node inHead = in.head;
    while(inHead != null) {
      int sum = inHead.value + carry;
      result.insert(sum % 10);
      carry = sum / 10;
      inHead = inHead.next;
    }
    if(carry == 1) {
      result.insert(carry);
    }
    result.printList(result.head);
  }
}

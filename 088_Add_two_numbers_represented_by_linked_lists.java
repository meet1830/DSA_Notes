/*
Add two numbers represented by linked lists

Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.
The sum list is a linked list representation of the addition of two input numbers from the last.

Input
The first line inputs N and M ,the size of two linked lists.
The second line inputs the value of N nodes of 1st linked list.
The third line inputs the value of M nodes of 2nd linked list.\

Constraints:
1 <= N, M <= 5000

Output
Print the sum list in new line.

Example
Input:
2 3
4 5 
3 4 5
Output:
3 9 0

Explaination:
For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).

*/



import java.util.*;

public class Main {
  class Node {
    int value;
    Node next;
    Node(int value) {
      this.value = value;
    }
  }
  Node head;
  
  void insertFirst(int value) {
    if(head == null) {
      head = new Node(value);
      return;
    }
    Node add = new Node(value);
    add.next = head;
    head = add;
  }
  
  void printList() {
    Node print = head;
    while(print != null) {
      System.out.print(print.value + " ");
      print = print.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int size1 = input.nextInt(), size2 = input.nextInt();
    Main list1 = new Main(), list2 = new Main();
    for(int i = 0; i < size1; i++) {
      list1.insertFirst(input.nextInt());
    }
    for(int i = 0; i < size2; i++) {
      list2.insertFirst(input.nextInt());
    }
    Main result = new Main();
    Node head1 = list1.head, head2 = list2.head;
    int sum = 0, carry = 0;
    while(head1 != null && head2 != null) {
      sum = head1.value + head2.value + carry;
      result.insertFirst(sum % 10);
      carry = sum / 10;
      head1 = head1.next;
      head2 = head2.next;
    }
    while(head1 != null) {
      sum = head1.value + carry;
      result.insertFirst(sum % 10);
      carry = sum / 10;
      head1 = head1.next;
    }
    while(head2 != null) {
      sum = head2.value + carry;
      result.insertFirst(sum % 10);
      carry = sum / 10;
      head2 = head2.next;
    }
    if(carry == 1) {
      result.insertFirst(1);
    }
    result.printList();
  }
}

public class Stack {
  // variables
  int top = -1;
  // data structure
  int[] arr;

  // define stack constructor for length
  Stack(int length) {
    arr = new int[length];
  }

  // stack methods
  void push(int value) {
    // check for stack overflow
    if (isFull()) {
      System.out.println("Stack overflow error!");
      return;
    }
    arr[++top] = value;
  }

  int pop() {
    // check for stack underflow error
    if (isEmpty()) {
      System.out.println("Stack underflow error!");
      return Integer.MIN_VALUE;
    }
    return arr[top--];
  }

  boolean isEmpty() {
    return top == -1;
  }

  boolean isFull() {
    return top == (arr.length - 1);
  }

  int peak() {
    // check for stack underflow error
    if (isEmpty()) {
      System.out.println("Stack underflow error!");
    }
    return arr[top];
  }
}

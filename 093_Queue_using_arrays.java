class Queue {
  int front = 0, rear = 0, count = 0, n;
  int[] arr;

  Queue(int length) {
    arr = new int[length];
    n = length;
  }

  // enqueue
  void push(int val) {
    if (count == n) {
      System.out.println("Queue Overflow error");
      return;
    }
    arr[rear % n] = val;
    rear++;
    count++;
  }

  // dequeue
  int pop() {
    if (count == 0) {
      System.out.println("Queue Underflow error");
      return Integer.MIN_VALUE;
    }
    int returnVal = arr[front % n];
    front++;
    count--;
    return returnVal;
  }

  int peek() {
    if (count == 0) {
      System.out.println("Queue Underflow error");
      return Integer.MIN_VALUE;
    }
    return arr[front % n];
  }

  void printQueue() {
    for (int i = front; i < rear; i++) {
      System.out.print(arr[i % n] + " ");
    }
    System.out.println();
  }
}

public class Main {
  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.pop();
    q.push(1);
    q.push(2);
    q.push(3);
    System.out.println(q.pop());
    System.out.println(q.peek());
    q.push(4);
    q.push(5);
    q.push(6);
    q.push(7);
    q.printQueue();
  }
}

/* Queue Underflow error
1
2
Queue Overflow error
2 3 4 5 6 */
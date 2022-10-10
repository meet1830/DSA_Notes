import java.util.EmptyStackException;

public class Stack {
    private Node head;
    private int size;
    
    private class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void push(int val) {
        Node push = new Node(val);
        push.next = head;
        head = push;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int returnVal = head.val;
        head = head.next;
        size--;
        return returnVal;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
        // return head == null;
    }

    // linked list is not of defined size hence isFull does not apply here

    public void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

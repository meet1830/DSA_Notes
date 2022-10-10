class Deque {
    int front, rear, cap;
    int[] arr;

    public Deque(int length) {
        arr = new int[length];
        front = -1;
        rear = 0;
        cap = length; 
    }

    public boolean isFull() {
        return (front == 0 && rear == cap - 1 || front == rear + 1);
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public void insertFront(int val) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0; rear = 0;
        }
        else if (front == 0) front = cap - 1;

        else front = front - 1;

        arr[front] = val;
    }

    public void insertBack(int val) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (front == -1) {
            front = 0; rear = 0;
        }
        else if (rear == cap - 1) rear = 0;

        else rear = rear + 1;

        arr[rear] = val;
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }

        int returnVal = arr[front];
        if (front == rear) {
            front = -1; rear = -1;
        }
        else if (front == cap - 1) front = 0;

        else front = front + 1;

        return returnVal;
    }

    public int deleteBack() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }

        int returnVal = arr[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (rear == 0) rear = cap - 1;

        else rear = rear - 1;

        return returnVal;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int getBack() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }
}
public class Main {
    public static void main(String[] args) {
        Deque dq = new Deque(5);

        dq.insertBack(5);

        dq.insertBack(10);

        System.out.println(dq.getBack());

        dq.deleteBack();

        System.out.println(dq.getBack());

        dq.insertFront(15);

        System.out.println(dq.getFront());

        dq.deleteFront();

        System.out.println(dq.getFront());
    }
}

/* 10
5
15
5 */
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Queue q = new Queue(3);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    
    q.enqueue(40);
    // overflow prints

    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    q.enqueue(40);
    System.out.println(q.dequeue());

    System.out.println(q.dequeue());
    // underflow prints

    /*
    Queue Overflow!
    10
    20
    30
    40
    Queue Underflow!
    -2147483648
    */




    Scanner input = new Scanner(System.in);
    Queue q2 = new Queue(input.nextInt());

    while(true) {
      int option = input.nextInt();
      switch(option) {
        case 0:
          q2.enqueue(input.nextInt());
          break;
        case 1:
          System.out.println(q2.dequeue());
          break;
     }
    }

    /*
    3
    0
    10
    0
    20
    0
    30
    0
    40
    Stack Overflow!
    1
    10
    1
    20
    1
    30
    1
    Stack Underflow!
    -2147483648
    */
  }
}
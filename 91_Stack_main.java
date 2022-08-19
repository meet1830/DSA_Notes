import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter size of stack: ");
    Stack st = new Stack(input.nextInt());
    while (true) {
      // infinite loop exit with ctrl + c
      System.out.println();
      System.out.println("Enter 0 to push \nEnter 1 to pop \nEnter 2 to peek");
      int in = input.nextInt();
      switch(in) {
        case 0:
          System.out.print("Enter value to push: ");
          st.push(input.nextInt());
          break;
        case 1:
          System.out.println(st.pop());
          break;
        case 2: 
          System.out.println(st.peak());
          break;
        default:
          System.out.println("Please enter correct value: ");
      }
    }
  }
}

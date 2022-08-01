package CLL_3;

public class CLL_main {
  public static void main(String[] args) {
    CLL_list list = new CLL_list();

    list.insertLast(2);
    list.insertLast(4);
    list.insertLast(10);
    list.insertLast(3);
    list.insertLast(5);
    list.printList();

    // list.delete(5);
    // list.delete(2);
    // list.printList();

    // list.printReverse();
  }
}

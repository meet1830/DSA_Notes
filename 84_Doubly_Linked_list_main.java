package DLL_2;

public class DLL_1_main {
  public static void main(String[] args) {
    DLL_1_list list = new DLL_1_list();

    list.insertFirst(14);
    list.insertFirst(5);
    list.insertFirst(6);
    list.insertFirst(17);
    // list.printList();
    // output -> 17 6 5 14 | 14 5 6 17 

    list.insertLast(18);
    // list.printList();
    // output -> 17 6 5 14 18 | 18 14 5 6 17 

    list.insert(100, 2);
    // list.printList();
    // output -> 17 6 100 5 14 18 | 18 14 5 100 6 17 

    list.insertAfter(100, 101);
    list.printList();
    // output -> 17 6 100 101 5 14 18 | 18 14 5 101 100 6 17 

  }
}

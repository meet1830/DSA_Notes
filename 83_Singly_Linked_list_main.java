package LL_1;

public class LL_1_main {
  public static void main(String[] args) {

    LL_1_list list = new LL_1_list();
    // initialises with size 0 and a head and tail

    list.insertFirst(3);
    list.insertFirst(2);
    list.insertFirst(8);
    list.insertFirst(17);
    // list.printList();
    // output -> 17 8 2 3

    list.insertLastWithTail(34);
    list.insertLast(35);
    // list.printList();
    // System.out.println(list.size);
    // output -> 17 8 2 3 34 35 | 6

    list.insert(100, 3);
    // list.printList();
    // System.out.println(list.size);
    // output -> 17 8 2 100 3 34 35 | 7

    int deleteFirst = list.deleteFirst();
    // list.printList();
    // System.out.println(list.size);
    // System.out.println(deleteFirst);
    // output -> 8 2 100 3 34 35 | 6 | 17

    int deleteLast = list.deleteLast();
    // list.printList();
    // System.out.println(list.size);
    // System.out.println(deleteLast);
    // output -> 8 2 100 3 34 | 5 | 35

    int deleteAt = list.delete(3);
    // list.printList();
    // System.out.println(list.size);
    // System.out.println(deleteAt);
    // output -> 8 2 100 34 | 4 | 3

    list.insertRec(101, 2);
    list.printList();

  }
}

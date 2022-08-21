import java.util.*;

public class Main {
    public static void main(String[] args) {
      int i = 0;
      System.out.print("1 -> ");
      
          while(i++ < 6) {
            System.out.print(i + " ");
          }
      
      i = 0;
      System.out.println();
      System.out.print("2 -> ");
      
          while(++i < 6) {
            System.out.print(i + " ");
          }
      
      i = 0;
      System.out.println();
      System.out.print("3 -> ");
      
          while(i < 6) {
            System.out.print(i++ + " ");
          }
      
      i = 0;
      System.out.println();
      System.out.print("4 -> ");
      
          while(i < 6) {
            System.out.print(++i + " ");
          }
      
      i = 0;
      System.out.println();
      System.out.print("5 -> ");
      
          while(i < 6) {
            System.out.print(i++ + " ");
            i = i++;
            System.out.print(i + " ");
          }
      
      i = 0;
      System.out.println();
      System.out.print("6 -> ");
      
          while(i < 6) {
            System.out.print(++i + " ");
            i = ++i;
            System.out.print(i + " ");
          }
    }
}

/*
1 -> 1 2 3 4 5 6 
2 -> 1 2 3 4 5 
3 -> 0 1 2 3 4 5 
4 -> 1 2 3 4 5 6 
5 -> 0 1 1 2 2 3 3 4 4 5 5 6 
6 -> 1 2 3 4 5 6 
*/

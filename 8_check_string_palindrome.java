import java.util.Scanner;

public class L1_check_string_palindrome {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String s = input.next();
    int start = 0, end = s.length()-1;
    int flag = 0;
    while (start<end) {
      if(s.charAt(start) != s.charAt(end)) {
        System.out.println("Not palindrome");
        break;
      } else flag = 1;
      start++; end--;
    }
    if (flag == 1) System.out.println("Palindrome");
    input.close();
  }
}

// print permutations of string -> pepcoding

public class Main {
  public static void printPermutations(String input, String ans) {
    // base
    if(input.length() == 0) {
      System.out.println(ans);
      return;
    }
    
    for(int i=0; i<input.length(); i++) {
      char ch = input.charAt(i);
      String left = input.substring(0, i);
      String right = input.substring(i + 1);
      String ros = left + right;
      printPermutations(ros, ans + ch);
    }
  }
  public static void main(String args[]) {
    String input = "abc";
    printPermutations(input, "");
  }
}

/*
abc
acb
bac
bca
cab
cba
*/

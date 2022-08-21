// ALGORITHM -> POWER SET -> requires bit manipulation
// to generate all subsequences

/*
-> program to print subsequences of an array
-> subsequences means all subarrays in order 
-> in order means if array is 3,1,2 then 3,2 is true, 1,2 is true but 1, 3 is false
-> may or may not be contiguous (subarrays always contiguous)
-> means for 3,1,2 3,2 true but false for subarray
*/

import java.util.*;

public class P5_print_subsequences {
  public static void subs(int[] arr, int index, ArrayList<Integer> sub) {
    if (index >= arr.length) {
      System.out.println(sub);
      return;
    }
    // take or pick the particular index into the subsequence
    sub.add(arr[index]);
    subs(arr, index + 1, sub);
    
    sub.remove(sub.size() - 1);
    // not pick, or not take condition, this element is not added to your subsequences
    subs(arr, index + 1, sub);

    // subs(arr, index + 1, sub);
    // sub.add(arr[index]);
    // subs(arr, index + 1, sub);
    // sub.remove(sub.size() - 1);
  }

  public static void main(String args[]) {
    int[] arr = {3, 1, 2};
    ArrayList<Integer> sub = new ArrayList<>();
    subs(arr, 0, sub);
  }
}

/* FOR FIRST SNIPPET
[3, 1, 2]
[3, 1]
[3, 2]
[3]
[1, 2]
[1]
[2]
[]
*/

/* FOR SECOND SNIPPET
[]
[2]
[1]
[1, 2]
[3]
[3, 2]
[3, 1]
[3, 1, 2]
*/

// Time complexity -> O(2^n) as two options to take and not to take
// Space -> O(n) as max 3,1,2 (3 items) will be waiting in the stack space



// Print subsequence for string

import java.util.*;
public class MyClass {
    public static void subs (String s, String sub, int n) {
        // base 
        if (s.length() == 0) {
            System.out.print(sub + " ");
            return;
        }
        // pick
        subs(s.substring(1), sub + s.charAt(0), n);
        // not pick
        subs(s.substring(1), sub, n);
        // output -> mit mi mt m it i t _
        
        // subs(s.substring(1), sub, n);
        // sub = sub + s.charAt(0);
        // subs(s.substring(1), sub, n);
        // sub = sub.substring(0, sub.length() - 1);
        // // output -> _ t i it m mt mi mit
        
        
    }
    public static void main (String args[]) {
        String s = "mit";
        int size = s.length();
        String sub = "";
        subs(s, sub, size);
    }
}


// GET subsequence for string pepcoding approach
import java.util.*;
public class Main {
    public static ArrayList<String> printsubs(String input) {
        // base
        if (input.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
         
        char ch = input.charAt(0);
        String roq = input.substring(1);
        ArrayList<String> ans = printsubs(roq);
        
        ArrayList<String> output = new ArrayList<>();
        for (String i : ans) {
            output.add("" + i);
            output.add(ch + i);
        }
        return output;
    }
    public static void main (String args[]) {
        String input = "abc";
        ArrayList<String> output = printsubs(input);
        System.out.println(output);
    }
}

// output -> [, a, b, ab, c, ac, bc, abc]



// PRINT subsequence for string pepcoding

public class Main {
  public static void printSubs(String input, String ans) {
    // base
    if (input.length() == 0) {
      System.out.println(ans);
      return;
    }
    
    char ch = input.charAt(0);
    String roq = input.substring(1);
    
    printSubs(roq, ans + "");
    printSubs(roq, ans + ch);
  }
  public static void main(String args[]) {
    String input = "abc";
    printSubs(input, "");
  }
}

/*

c
b
bc
a
ac
ab
abc
*/

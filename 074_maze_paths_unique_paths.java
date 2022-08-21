/*
Print Maze Paths

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of pri tMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10
0 <= m <= 10

Format
Input
A number n
A number m

Output
Print paths (one path in each line) in order hinted by Sample output

Example
Sample Input
2
2

Sample Output
hv
vh
*/

import java.util.*;
public class MyClass {
    public static ArrayList<String> mazePaths(int cr, int cc, int m, int n) {
        // base
        if (cr == m && cc == n) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        
        // at the last row -> only horizontal mov is possible and at last col -> only vertical move 
        if (cr < m) {
            vpaths = mazePaths(cr + 1, cc, m, n);
        }
        if (cc < n) {
            hpaths = mazePaths(cr, cc + 1, m, n); 
        }
        
        ArrayList<String> paths = new ArrayList<>();
        for (String hpath : hpaths) {
            paths.add("h" + hpath);
        }
        for (String vpath : vpaths) {
            paths.add("v" + vpath);
        }
        return paths;
    }
    public static void main(String args[]) {
        int m = 3, n = 3;
        ArrayList<String> paths = mazePaths(1, 1, m, n);
        System.out.println(paths);
    }
}



/*
Leetcode -> Unique paths
below code works only till m, n -> 17
*/
import java.util.*;
public class MyClass {
    public static int mazePaths(int cr, int cc, int m, int n) {
        // base
        if (cr == m && cc == n) {
            return 1;
        }
        
        int hpaths = 0;
        int vpaths = 0;
        
        // at the last row -> only horizontal mov is possible and at last col -> only vertical move 
        if (cr < m) {
            vpaths = mazePaths(cr + 1, cc, m, n);
        }
        if (cc < n) {
            hpaths = mazePaths(cr, cc + 1, m, n); 
        }
        return vpaths + hpaths;
    }
    public static void main(String args[]) {
        int m = 17, n = 17;
        int paths = mazePaths(1, 1, m, n);
        System.out.println(paths);
    }
}



// pepcoding -> print maze paths
public class Main {
  public static void printMazePaths(int cm, int cn, int m, int n, String ans) {
    
    // stupid call, smart base case {
    if (cm > m || cn > n) {
      return;
    }
    if (cm == m && cn == n) {
      System.out.println(ans);
      return;
    }
    printMazePaths(cm + 1, cn, m, n, ans + "v");
    printMazePaths(cm, cn + 1, m, n, ans + "h");
    // }
    
    // smart call, normal base case {
    // if (cm == m && cn == n) {
    //   System.out.println(ans);
    //   return;
    // }
    // if (cm < m) {
    //   printMazePaths(cm + 1, cn, m, n, ans + "v");
    // }
    // if (cn < n) {
    //   printMazePaths(cm, cn + 1, m, n, ans + "h");
    // }
    // }
  }
  public static void main(String args[]) {
    int m = 3, n = 3;
    printMazePaths(0, 0, m, n, "");
  }
}

/*
Print Maze Paths With Jumps -> https://nados.io/question/print-maze-paths-with-jumps

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 5
0 <= m <= 5

Format
Input
A number n
A number m

Output
Print paths (one path in each line) in order hinted by Sample output

Example
Sample Input
3
3

Sample Output
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2
*/

import java.util.*;
public class MyClass {
    public static ArrayList<String> mazeJump(int cr, int cc, int m, int n) {
        // base
        if (cr == m && cc == n) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        ArrayList<String> paths = new ArrayList<>();
        
        // horizontal
        for (int mh = 1; mh <= n - cc; mh++) {
            ArrayList<String> hpaths = mazeJump(cr, cc + mh, m, n);
            for (String hpath : hpaths) {
                paths.add("h" + mh + hpath);
            }
        }
        
        // vertical
        for (int mv = 1; mv <= m - cr; mv++) {
            ArrayList<String> vpaths = mazeJump(cr + mv, cc, m, n);
            for (String vpath : vpaths) {
                paths.add("v" + mv + vpath);
            }
        }
        
        // diagonal
        for (int md = 1; md <= m - cr && md <= n - cc; md++) {
            ArrayList<String> dpaths = mazeJump(cr + md, cc + md, m, n);
            for (String dpath : dpaths) {
                paths.add("d" + md + dpath);
            }
        }
        
        return paths;
    }
    public static void main(String args[]) {
        int m = 3, n = 3;
        ArrayList<String> paths = mazeJump(1, 1, m, n);
        for (String x : paths) {        
            System.out.println(x);
        }
    }
}



// pepcoding -> print maze paths

import java.util.*;
public class Main {
  public static void printMazePath(int cm, int cn, int m, int n, String ans) {
    // base
    if (cm == m && cn == n) {
      System.out.println(ans);
      return;
    }
    
    // move horizontal
    for (int mh = 1; mh <= n - cn; mh++) {
      printMazePath(cm, cn + mh, m, n, ans + "h" + mh);
    }
    
    // move vertical
    for (int mv = 1; mv <= m - cm; mv++) {
      printMazePath(cm + mv, cn, m, n, ans + "v" + mv);
    }
    
    // move diagonal
    for (int md = 1; md <= n - cn && md <= m - cm; md++) {
      printMazePath(cm + md, cn + md, m, n, ans + "d" + md);
    }
  }
  public static void main(String args[]) {
    int m = 3, n = 3;
    printMazePath(0, 0, m - 1, n - 1, "");
  }
}

/*
h1h1v1v1
h1h1v2
h1v1h1v1
h1v1v1h1
h1v1d1
h1v2h1
h1d1v1
h2v1v1
h2v2
v1h1h1v1
v1h1v1h1
v1h1d1
v1h2v1
v1v1h1h1
v1v1h2
v1d1h1
v2h1h1
v2h2
d1h1v1
d1v1h1
d1d1
d2
*/

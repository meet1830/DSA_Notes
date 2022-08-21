/*
LeetCode -> https://leetcode.com/problems/climbing-stairs/
70. Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 
Constraints:
1 <= n <= 45
*/

class Solution {
    public int climbStairs(int n) {
        // base 
        if (n == 0) {
            return 1;
        }
        else if (n < 0) {
            return 0;
        }
        
        int p = 0, q = 0, r = 0;
        p += climbStairs(n-1);
        q += climbStairs(n-2);
        
        return p + q;
    }
}

/*
Print Stair Paths -> pepcoding -> https://nados.io/question/print-stair-paths?zen=true
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
0 <= n <= 10

Format
Input
A number n

Output
Print paths (one path in each line) in order hinted by Sample output

Example
Sample Input
3

Sample Output
111
12
21
3
*/
import java.util.*;
public class MyClass {
    public static ArrayList<String> getStairsPath(int n) {
        // base 
        if (n == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if (n < 0) {
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }
        
        ArrayList<String> paths1 = getStairsPath(n-1);
        ArrayList<String> paths2 = getStairsPath(n-2);
        ArrayList<String> paths3 = getStairsPath(n-3);
        
        ArrayList<String> paths = new ArrayList<>();
        for (String path : paths1) {
            paths.add(1 + path);
        }
        for (String path : paths2) {
            paths.add(2 + path);
        }
        for (String path : paths3) {
            paths.add(3 + path);
        }
        return paths;
        
    }
    public static void main(String args[]) {
        int n = 4;
        ArrayList<String> paths = getStairsPath(n);
        System.out.println(paths);
    }
}

// print stair paths -> pepcoding

public class Main {
  public static void printStairPath(int input, String spaths) {
    // base
    if (input < 0) {
      return;
    }
    if (input == 0) {
      System.out.println(spaths);
      return;
    }
    
    printStairPath(input - 1, spaths + "1");
    printStairPath(input - 2, spaths + "2");
    printStairPath(input - 3, spaths + "3");
  }
  public static void main(String args[]) {
    int input = 4;
    printStairPath(input, "");
  }
}

/*
1111
112
121
13
211
22
31
*/

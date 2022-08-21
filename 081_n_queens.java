/*
Pepcoding -> N Queens

The N Queen is the problem of placing N queens on an N*N chessboard so that no two queens attack each other. Queen can kill other queens in all of the 8 directions possible (left, right, up, down, and all the 4 diagonals). Given the value of N, you have to print all the valid chess board configurations possible
*/


// code to put queens at all spaces without checking its safety
public class Main {
  public static void main(String args[]) {
    int n = 2;
    int[][] arr = new int[n][n];
    printNqueens(arr, 0, "");
  }
  public static void printNqueens(int[][] arr, int cm, String ans) {
    // base
    if (cm == arr.length) {
      System.out.println(ans);
      return;
    }
    
    for (int col = 0; col < arr.length; col++) {
      arr[cm][col] = 1;
      printNqueens(arr, cm + 1, ans + cm + "-" + col + ", ");
      arr[cm][col] = 0;
    }
  }
}

/*
0-0, 1-0, _
0-0, 1-1, _
0-1, 1-0, _
0-1, 1-1, _
*/



// complete code to put queens according to question

public class Main {
  public static void main (String args[]) {
    int n = 4;
    int[][] arr = new int[n][n];
    printNqueens(arr, 0, "");
  }
  public static void printNqueens (int[][] arr, int cm, String ans) {
    // base
    if (cm == arr.length) {
      System.out.println(ans + ".");
      return;
    }
    
    for (int col = 0; col < arr.length; col++) {
      if (checkQueenSafety(arr, cm, col)) {
        arr[cm][col] = 1;
        printNqueens(arr, cm + 1, ans + cm + "-" + col + ", ");
        arr[cm][col] = 0;
      }
    }
  }
  public static boolean checkQueenSafety (int[][] arr, int row, int col) {
    // checking vertical
    for (int i = row - 1, j = col; i >= 0; i--) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    
    // checking diagonal in direction backslash
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    
    // checking diagonal in direction forwardslash
    for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
      if (arr[i][j] == 1) {
        return false;
      }
    }
    
    return true;
  }
}

/*
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/

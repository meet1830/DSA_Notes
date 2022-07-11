// Recusrion -> Factorial
// public class P1_Recursion {
//   public static int factorial (int n) {
//     if(n==1 || n==0) return 1; 
//     return n*factorial(n-1);
//   }
//   public static void main(String[] args) {
//     int n = 5;
//     System.out.println(factorial(n));
//   }
// }

// Recursion -> Fibonacci
// public class P1_Recursion {
//   public static int fibonacci(int n) {
//     if(n==1 || n==2) return 1;
//     return fibonacci(n-1) + fibonacci(n-2);
//   }
//   public static void main(String[] args) {
//     int n = 5;
//     System.out.println(fibonacci(n));
//   }
// }

// TIME COMPLEXITY for above question -> for every function call -> two recursive function calls are being made -> hence n -> 2 calls, n-1 -> 2 calls, n-2 -> 2 calls hence complexity near about to explonential O(2^n). 


// Recursion -> HCF/GCD
// import java.util.Scanner;
// public class P1_Recursion {
// public static int hcf(int a, int b) {
//	 if (b==0) return a;
//   if (a%b==0) return b;
//   return hcf(b, a%b);
// }
// public static void main(String[] args) {
// int a = 400, b = 60;
// System.out.println(hcf(a,b));

/*
int a = 400, b = 60;
for (int i = 0; i<a; i++) {
  if(a==b) {
    System.out.println(a);
    return;
  }
  else if (a>b) {
    a = a-b;
  }
  else {
    b = b-a;
  }
}
System.out.println(a);
*/
//   }
// }

import java.io.*;
import java.util.*;
public class P1_Recursion {
  public static int sum(int n, int arr[]) {
    if(n<=0) return 0;
    return (arr[n-1] + sum(n-1, arr));
  }
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      int t = input.nextInt(), n = input.nextInt();
      int[] arr = new int[n];
      for (int j=0; j<t; j++) {
        for (int i=0; i<n; i++) {
          arr[i] = input.nextInt();
        }
        System.out.println(sum(n, arr));
      }
      input.close();
    }
}

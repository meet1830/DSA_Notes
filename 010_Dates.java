/*
Dates
Peter has the task to write a program that processes N strings. Some of them have Russian and European format "day.month.year", while others use American format — "month/day/year". Here, year is a number from 1 to 9999, which may contain leading zeroes to get 2, 3 or 4 digits, month — number from 1 to 12, which may contain leading zero to get 2 digits, day — number from 1 to 31, which may contain leading zeros to get 2 digits. Print each date in two formats: first as "DD.MM.YYYY", second as "MM/DD/YYYY".

Example
Sample Input 2 11.12.2000 1.2.1

Sample Output 11.12.2000 12/11/2000 01.02.0001 02/01/0001

Sample Input 2 20.10.2100 1/29/3000

Sample Output 20.10.2100 10/20/2100 29.01.3000 01/29/3000

Input Format
The first line of input contains one integer N (1 <= N <= 100).

Each of the following N lines contain one date in format "day.month.year" or "month/day/year".

Output Format
Print 𝑛 lines. Each line should contain the date in two formats: first as "DD.MM.YYYY", second as "MM/DD/YYYY".
*/

// import java.util.*;

// public class A2_Dates {
//   public static void main(String args[]) {
//     Scanner input = new Scanner(System.in);
//     int n = input.nextInt();
//     String s = "";
//     String[] arr = new String[3];
//     for (int i = 0; i < n; i++) {
//       s = input.next();
//       if (s.contains(".")) {
//         arr = s.split("\\.", 3);
//       } else
//         arr = s.split("\\/", 3);

//       // printing values
//       if (Integer.parseInt(arr[1]) <= 12) {

//         // printing day(.)
//         if (Integer.parseInt(arr[0]) < 10)
//           System.out.print("0" + arr[0] + ".");
//         else
//           System.out.print(arr[0] + ".");
//         // printing month(.)
//         if (Integer.parseInt(arr[1]) < 10)
//           System.out.print("0" + arr[1] + ".");
//         else
//           System.out.print(arr[1] + ".");
//         // printing year(.)
//         if (Integer.parseInt(arr[2]) < 10)
//           System.out.print("000" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 100)
//           System.out.print("00" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 1000)
//           System.out.print("0" + arr[2] + " ");
//         else
//           System.out.print(arr[2] + " ");

//         // printing day(/)
//         if (Integer.parseInt(arr[1]) < 10)
//           System.out.print("0" + arr[1] + "/");
//         else
//           System.out.print(arr[1] + "/");
//         // printing month(/)
//         if (Integer.parseInt(arr[0]) < 10)
//           System.out.print("0" + arr[0] + "/");
//         else
//           System.out.print(arr[0] + "/");
//         // printing year(/)
//         if (Integer.parseInt(arr[2]) < 10)
//           System.out.print("000" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 100)
//           System.out.print("00" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 1000)
//           System.out.print("0" + arr[2] + " ");
//         else
//           System.out.print(arr[2] + " ");
//       }

//       else {
//         // printing day(.)
//         if (Integer.parseInt(arr[1]) < 10)
//           System.out.print("0" + arr[1] + ".");
//         else
//           System.out.print(arr[1] + ".");
//         // printing month(.)
//         if (Integer.parseInt(arr[0]) < 10)
//           System.out.print("0" + arr[0] + ".");
//         else
//           System.out.print(arr[0] + ".");
//         // printing year(.)
//         if (Integer.parseInt(arr[2]) < 10)
//           System.out.print("000" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 100)
//           System.out.print("00" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 1000)
//           System.out.print("0" + arr[2] + " ");
//         else
//           System.out.print(arr[2] + " ");

//         // printing day(/)
//         if (Integer.parseInt(arr[0]) < 10)
//           System.out.print("0" + arr[0] + "/");
//         else
//           System.out.print(arr[0] + "/");
//         // printing month(/)
//         if (Integer.parseInt(arr[1]) < 10)
//           System.out.print("0" + arr[1] + "/");
//         else
//           System.out.print(arr[1] + "/");
//         // printing year(/)
//         if (Integer.parseInt(arr[2]) < 10)
//           System.out.print("000" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 100)
//           System.out.print("00" + arr[2] + " ");
//         else if (Integer.parseInt(arr[2]) < 1000)
//           System.out.print("0" + arr[2] + " ");
//         else
//           System.out.print(arr[2] + " ");
//       }
//     }
//     input.close();
//   }
// }


import java.util.*;
public class A2_Dates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            String ans = scan.next();
            str[i] = ans;
        }
        for (String k : str) {
            if (k.contains(".")) {
                String dms[] = k.split("\\.");
                System.out.printf("%02d.%02d.%04d", Integer.parseInt(dms[0]), Integer.parseInt(dms[1]),Integer.parseInt(dms[2]));
                System.out.print(" ");
                System.out.printf("%02d/%02d/%04d", Integer.parseInt(dms[1]), Integer.parseInt(dms[0]),Integer.parseInt(dms[2]));
                System.out.print(" ");
            } else {
                String dms[] = k.split("\\/");
                System.out.printf("%02d/%02d/%04d", Integer.parseInt(dms[0]), Integer.parseInt(dms[1]),Integer.parseInt(dms[2]));
                System.out.print(" ");
                System.out.printf("%02d.%02d.%04d", Integer.parseInt(dms[1]), Integer.parseInt(dms[0]),Integer.parseInt(dms[2]));
                System.out.print(" ");
            }
        }
        scan.close();
    }
}
/*
Stopwatch
Robin just received a stopwatch from her grandfather. Robin’s stopwatch has a single button. Pressing the button alternates between stopping and starting the stopwatch’s timer. When the timer is on, the displayed time increases by 1 every second.

Initially the stopwatch is stopped and the timer reads 0 seconds. Given a sequence of times that the stopwatch button is pressed, determine what the stopwatch’s timer displays.

Input
The first line of input contains a single integer N (1≤N≤1000), which is the number of times the stopwatch was pressed.

The next N lines describe the times the stopwatch’s button was pressed in increasing order. Each line contains a single integer t (0≤t≤106), which is the time the button was pressed. No two button presses happen on the same second.

Output
Display still running if the stopwatch’s timer is still running after all button presses were made. Otherwise display the number of seconds displayed on the timer of tne stopwatch.

Sample Input 1
2
7
11
Sample Output 1
4

Sample Input 2
5
2
5
9
10
17
Sample Output 2
still running

Sample Input 3
4
0
2
104
117
Sample Output 3
15
*/

import java.util.*;

public class A2_Stopwatch {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }
    int time = 0, state = 0;
    for (int i = 1; i <= n; i += 2) {
      if (n % 2 != 0) {
        System.out.println("still running");
        break;
      } else {
        time += arr[i] - arr[i - 1];
        state = 1;
      }
    }
    if (state == 1)
      System.out.println(time);
    input.close();
  }
}

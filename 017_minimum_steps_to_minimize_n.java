/*
To count the minimum number of steps needed to reduce given number to 1 using the given operations. 
divide by 3, divide by 2 and subtract by 1.

Solution: https://www.geeksforgeeks.org/minimum-steps-minimize-n-per-given-condition/
*/

import java.util.Scanner;
public class P2_minimum_steps_to_minimize_n {
    public static int minSteps(int n) {
        if(n == 1) {
            return 0;
        }
        else {
            int sub1 = Integer.MAX_VALUE;
            int div2 = Integer.MAX_VALUE;
            int div3 = Integer.MAX_VALUE;
            if (n % 2 == 0) {
                div2 = minSteps(n / 2);
            }
            if (n % 3 == 0) {
                div3 = minSteps(n / 3);
            } 
            sub1 = minSteps(n - 1);
            return 1 + Math.min(sub1, Math.min(div3, div2));
        }
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(minSteps(n));
    }
}

// approach without recursion
/*
import java.util.Scanner;
public class MyClass {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        while (n > 1) { 
            if (n%3==0) {
                count++;
                n /= 3;
            }
            if (n%2==0) {
                count++;
                n /= 2;
            }
            n -= 1;
            count++;
        }
        System.out.println(count);
    }
}
*/

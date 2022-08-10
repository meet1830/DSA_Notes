// program to print sum of first n numbers (n = 3 -> 1+2+3 = 6)

// parameterized way -> printing ans

public class MyClass {
    public static void sum (int n, int sum) {
        // base
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum(n-1, sum + n);
    }
    public static void main(String args[]) {
        int n = 3, sum = 0;
        sum(n, sum);
    }
}


// functional way -> returning ans
public class MyClass {
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n-1);
    }
    public static void main (String args[]) {
        int n = 3;
        int sum = sum(n);
        System.out.println(sum);
    }
}
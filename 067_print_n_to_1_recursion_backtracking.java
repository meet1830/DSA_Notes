// program to print n -> 1 using recursion backtracking
// here without using i - 1

public class MyClass {
    public static void print (int n, int i) {
        // base
        if (n<1) {
            return;
        }
        print(n-1, i+1);
        System.out.print(i + " ");
    }
    public static void main(String args[]) {
        int n = 3;
        int i = 1;
        print(n, i);
    }
}

// output -> 3 2 1

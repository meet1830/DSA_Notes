// program to print 1 -> N using recursion backtracking 
// here dont use i + 1

public class MyClass {
    public static void print (int i) {
        // base
        if (i<1) {
            return;
        }
        print(i-1);
        System.out.print(i + " ");
    }
    public static void main(String args[]) {
        int n = 3;
        print(n);
    }
}

// output -> 1 2 3

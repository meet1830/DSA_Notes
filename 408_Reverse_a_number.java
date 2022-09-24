// WAP to reverse a number
public class Main {
    public static void main(String[] args) {
        int num = 12345;
        int n = num;
        int size = (n + "").length();
        int ans = 0;
        for (int i = size - 1; i >= 0; i--) {
            ans += (Math.pow(10, i) * (n % 10));
            n /= 10;
        }
        System.out.println(ans);
    }
}

// 54321
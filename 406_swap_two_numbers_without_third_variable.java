public class Main {
    public static void main(String[] args) {
        int x = 23, y = 34;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(x + " " + y);
        // 34 23
    }
}

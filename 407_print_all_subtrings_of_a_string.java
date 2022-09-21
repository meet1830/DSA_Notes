// two for loops - the only method
public class Main {
    public static void main(String[] args) {
        String str = "abc";
        int n = str.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                if (str.substring(i, j).length() > 0)
                    ans.add(str.substring(i, j));
            }
        }
        System.out.println(ans);
    }
}

public class factorial {
  // bottom up recursive
  public static int factRec(int x) {
    if (x == 1)
      return 1;

    return x * fact(x - 1);
  }

  // top down approach
  public static int factIter(int x) {
    int result = 1;
    if (x == 0)
      return 1;

    for (int i = 1; i <= x; i++) {
      result *= i;
    }

    return result;
  }
}
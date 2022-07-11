//RECURSION-1 PRACTICE QUESTIONS -> CODINGBAT.COM

/* 1 - bunnyEars

We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
bunnyEars(0) → 0
bunnyEars(1) → 2
bunnyEars(2) → 4

public static int bunnyEars(int bunnies) {
  //base case
  if (bunnies == 0) return 0;
  //others 
  else {
    return 2 + bunnyEars(bunnies-1);
  }
}
*/

/* 2 - bunnyEars2

We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5

public int bunnyEars2(int bunnies) {
  if (bunnies == 0) return 0;
  if (bunnies%2 == 0) {
    return 3 + bunnyEars2(bunnies-1);
  }
  else return 2 + bunnyEars2(bunnies-1);
}
*/

/* 3 - triangle

We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
triangle(0) → 0
triangle(1) → 1
triangle(2) → 3

public int triangle(int rows) {
  if (rows == 0) return 0;
  else {
    return rows + triangle(rows-1);
  }
}
*/

/* 4 - triangle

We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
triangle(0) → 0
triangle(1) → 1
triangle(2) → 3

public int triangle(int rows) {
  if (rows == 0) return 0;
  else {
    return rows + triangle(rows-1);
  }
}
*/

/* 5 - count7

Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops).
count7(717) → 2
count7(7) → 1
count7(123) → 0

public class Codingbat_Recursion_1 {
  public static int count7(int n) {
    int count = 0;
    if(n==0) return 0;
    if(n%10==7) {
      count++;
    }
    return count + count7(n/10);
  }
  public static void main(String[] args) {
    int n = 717;
    System.out.println(count7(n));
  }
}
*/

/* 6 - count8

Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
count8(8) → 1
count8(818) → 2
count8(8818) → 4

// public class Codingbat_Recursion_1 {
//   public static int count8(int n) {
//     if (n == 0)
//       return 0;
//     int count = 0;
//     if (n % 10 == 8) {
//       count++;
//     }
//     if (n % 100 == 88) {
//       count += 1;
//     }
//     return count + count8(n / 10);
//   }

//   public static void main(String[] args) {
//     int n = 8818;
//     System.out.println(count8(n));
//   }
// }
*/

/* 7 - powerN  

Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
powerN(3, 1) → 3
powerN(3, 2) → 9
powerN(3, 3) → 27

public int powerN(int base, int n) {
  if(n==0) return 1;
  else {
    return base * powerN(base, n-1);
  }
}
*/

/* 8 - countX  

Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
countX("xxhixx") → 4
countX("xhixhix") → 3
countX("hi") → 0

public int countX(String str) {
  if (str.length()==0) return 0;
  else{
    int count = 0;
    if (str.charAt(0)=='x') {
      count++;
    }
    return count + countX(str.substring(1));
  }
}
*/

/* 9 - countHi  

Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
countHi("xxhixx") → 1
countHi("xhixhix") → 2
countHi("hi") → 1

public int countHi(String str) {
  if (str.length()<2) return 0;
  int count = 0;
  String firstTwo = str.substring(0,2);
  if (firstTwo.equals("hi")){
    count++;
  }
  return count + countHi(str.substring(1));
}
*/

/* 10 - changeXY  

Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars.
changeXY("codex") → "codey"
changeXY("xxhixx") → "yyhiyy"
changeXY("xhixhix") → "yhiyhiy"

public String changeXY(String str) {
  if (str.length()==0) return str;
  if (str.charAt(0)=='x') {
    return "y" + changeXY(str.substring(1));
  }
  else {
    return str.charAt(0) + changeXY(str.substring(1));
  }
}
*/

/* 11 - changePi  

Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14".
changePi("xpix") → "x3.14x"
changePi("pipi") → "3.143.14"
changePi("pip") → "3.14p"

public String changePi(String str) {
  if (str.length() < 2) return str;
  String firstTwo = str.substring(0,2);
  if (firstTwo.equals("pi")) {
    return "3.14" + changePi(str.substring(2));
  }
  else {
    return str.charAt(0) + changePi(str.substring(1));
  }
}
*/

/* 12 - noX  

Given a string, compute recursively a new string where all the 'x' chars have been removed.
noX("xaxb") → "ab"
noX("abc") → "abc"
noX("xx") → ""

public String noX(String str) {
  if (str.length()==0) return str;
  if (str.charAt(0)=='x'){
    return noX(str.substring(1));
  }
  else {
    return str.charAt(0) + noX(str.substring(1));
  }
}
*/

/* 13 - array6  

Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
array6([1, 6, 4], 0) → true
array6([1, 4], 0) → false
array6([6], 0) → true

public boolean array6(int[] nums, int index) {
  if (index == nums.length) return false;
  if (nums[index]==6) {
    return true;
  }
  else {
    return array6(nums, index+1);
  }
}
*/

/* 14 - array11  

Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
array11([1, 2, 11], 0) → 1
array11([11, 11], 0) → 2
array11([1, 2, 3, 4], 0) → 0

public int array11(int[] nums, int index) {
  if (index == nums.length) return 0;
  if (nums[index]==11) {
    return 1 + array11(nums, index + 1);
  }
  else {
    return array11(nums, index + 1);
  }
}
*/

/* 15 - array220  

Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
array220([1, 2, 20], 0) → true
array220([3, 30], 0) → true
array220([3], 0) → false

public boolean array220(int[] nums, int index) {
  if (nums.length <= 1) return false;
  if (nums.length - 1 == index) return false;
  if (10*nums[index]==nums[index+1]) {
    return true;
  }
  else {
    return array220(nums, index + 1);
  }
}
*/

/* 16 - allStar  

Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
allStar("hello") → "h*e*l*l*o"
allStar("abc") → "a*b*c"
allStar("ab") → "a*b"

public String allStar(String str) {
  if (str.length()<=1) return str;
  else {
    return str.charAt(0) + "*" + allStar(str.substring(1)); 
  }
}
*/

/* 17 - pairStar  

Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
pairStar("hello") → "hel*lo"
pairStar("xxyy") → "x*xy*y"
pairStar("aaaa") → "a*a*a*a"

public String pairStar(String str) {
  if (str.length()<=1) return str;
  if (str.charAt(0) == str.charAt(1)) {
    return str.charAt(0) + "*" + pairStar(str.substring(1));
  }
  else {
    return str.charAt(0) + pairStar(str.substring(1));
  }
}
*/

/* 18 - endX  

Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.
endX("xxre") → "rexx"
endX("xxhixx") → "hixxxx"
endX("xhixhix") → "hihixxx"

public String endX(String str) {
  if (str.length()==0) return str;
  if (str.charAt(0)=='x') {
    return endX(str.substring(1)) + "x";
  }
  else{
    return str.charAt(0) + endX(str.substring(1));
  }
}
*/

/* 19 - countPairs  

We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string.
countPairs("axa") → 1
countPairs("axax") → 2
countPairs("axbx") → 1

public int countPairs(String str) {
  if (str.length()<3) return 0;
  if (str.charAt(0)==str.charAt(2)) {
    return 1 + countPairs(str.substring(1));
  }
  else {
    return countPairs(str.substring(1));
  }
}
*/

/* 20 - countAbc  

Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
countAbc("abc") → 1
countAbc("abcxxabc") → 2
countAbc("abaxxaba") → 2

public int countAbc(String str) {
  if (str.length()<=2) return 0;
  else {
    String firstThree = str.substring(0,3);
    if (firstThree.equals("abc") || firstThree.equals("aba")) {
      return 1 + countAbc(str.substring(1));
    }
    else {
      return countAbc(str.substring(1));
    }
  }
}
*/

/* 21 - count11  

Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
count11("11abc11") → 2
count11("abc11x11x11") → 3
count11("111") → 1

public int count11(String str) {
  if (str.length()<2) return 0;
  else {
    String eleven = str.substring(0,2);
    if (eleven.equals("11")) {
      return 1 + count11(str.substring(2));
    } 
    else {
      return count11(str.substring(1));
    }
  }
}
*/

/* 22 - stringClean  

Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".
stringClean("yyzzza") → "yza"
stringClean("abbbcdd") → "abcd"
stringClean("Hello") → "Helo"

public String stringClean(String str) {
  if (str.length()<2) return str;
  else {
    if (str.charAt(0) == str.charAt(1)) {
      return stringClean(str.substring(1));
    } 
    else {
      return str.charAt(0) + stringClean(str.substring(1));
    }
  }
}
*/

/* 23 - countHi2  

Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them.
countHi2("ahixhi") → 1
countHi2("ahibhi") → 2
countHi2("xhixhi") → 0

public int countHi2(String str) {
  if (str.length()<2) return 0;
  else {
    if (str.length()>=2 && str.substring(0,2).equals("hi")) {
      return 1 + countHi2(str.substring(1));
    } 
    else if (str.length()>=3 && str.substring(0,3).equals("xhi")) {
      return countHi2(str.substring(3));
    }
    else {
      return countHi2(str.substring(1));
    }
  }
}
*/

/* 24 - parenBit  

Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)".
parenBit("xyz(abc)123") → "(abc)"
parenBit("x(hello)") → "(hello)"
parenBit("(xy)1") → "(xy)"

public String parenBit(String str) {
  if (str.length()<3) return str;
  else {
    int strLength = str.length();
    String start = str.substring(0,1);
    String end = str.substring(strLength-1, strLength);
    if (start.equals("(") && !end.equals(")")) {
      return parenBit(str.substring(0,strLength-1));
    }
    else if (!start.equals("(") && end.equals(")")) {
      return parenBit(str.substring(1, strLength));
    }
    else if (!start.equals("(") && !end.equals(")")) {
      return parenBit(str.substring(1, strLength-1));
    }
    else {
      return str;
    }
  }
}
*/

/* 25 - nestParen  

Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.
nestParen("(())") → true
nestParen("((()))") → true
nestParen("(((x))") → false

public boolean nestParen(String str) {
  if (str.length()==0) return true;
  if (str.length()==1) return false;
  else {
    char start = str.charAt(0);
    char end = str.charAt(str.length()-1);
    if (start=='(' && end==')') {
      return nestParen(str.substring(1, str.length()-1));
    }
    else {
      return false;
    }
  }
}
*/

/* 26 - strCount  

Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.
strCount("catcowcat", "cat") → 2
strCount("catcowcat", "cow") → 1
strCount("catcowcat", "dog") → 0

public int strCount(String str, String sub) {
  if(str.length()<sub.length()) return 0;
  else {
    int subLength = sub.length();
    String temp = str.substring(0,subLength);
    if (temp.equals(sub)) {
      return 1 + strCount(str.substring(subLength), sub);
    }
    else {
      return strCount(str.substring(1), sub);
    }
  }
}
*/

/* 27 - strCopies  

Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
strCopies("catcowcat", "cat", 2) → true
strCopies("catcowcat", "cow", 2) → false
strCopies("catcowcat", "cow", 1) → true

public boolean strCopies(String str, String sub, int n) {
  if (str.length()<sub.length()) {
    if (n==0) {
      return true;
    }
    else {
      return false;
    }
  }
  else {
    String temp = str.substring(0, sub.length());
    if (temp.equals(sub)) {
      return strCopies (str.substring(1), sub, n-1);
    }
    else {
      return strCopies (str.substring(1), sub, n);
    }
  }
}
*/

/* 28 - strDist  

Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
strDist("catcowcat", "cat") → 9
strDist("catcowcat", "cow") → 3
strDist("cccatcowcatxx", "cat") → 9

public int strDist(String str, String sub) {
  if (str.length() < sub.length()) {
    return 0;
  }
  else if (str.length() == sub.length()) {
    if (str.equals(sub)) {
      return str.length();
    }
    else {
      return 0;
    }
  }
  else {
    int subL = sub.length();
    String strFirst = str.substring(0, subL);
    String strLast = str.substring(str.length()-subL);
    if (strFirst.equals(sub) && strLast.equals(sub)) {
      return str.length();
    }
    else if (strFirst.equals(sub) && !strLast.equals(sub)) {
      return strDist(str.substring(0, str.length()-1), sub);
    }
    else if (!strFirst.equals(sub) && strLast.equals(sub)) {
      return strDist(str.substring(1), sub);
    }
    else {
      return strDist(str.substring(1, str.length()-1), sub);
    }
  }
}
*/

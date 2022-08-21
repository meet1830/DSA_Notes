/*
Ptice
Adrian, Bruno and Goran wanted to join the bird lovers’ club. However, they did not know that all applicants must pass an entrance exam. The exam consists of N questions, each with three possible answers: A, B and C.

Unfortunately, they couldn’t tell a bird from a whale so they are trying to guess the correct answers. Each of the three boys has a theory of what set of answers will work best:

Adrian claims that the best sequence is: A, B, C, A, B, C, A, B, C, A, B, C ...

Bruno is convinced that this is better: B, A, B, C, B, A, B, C, B, A, B, C ...

Goran laughs at them and will use this sequence: C, C, A, A, B, B, C, C, A, A, B, B ...

Write a program that, given the correct answers to the exam, determines who of the three was right – whose sequence contains the most correct answers.

Input
The first line contains an integer N (1≤N≤100), the number of questions on the exam.

The second line contains a string of N letters ‘A’, ‘B’ and ‘C’. These are, in order, the correct answers to the questions in the exam.

Output
On the first line, output M, the largest number of correct answers one of the three boys gets.

After that, output the names of the boys (in alphabetical order) whose sequences result in M correct answers.

Sample Input 1
5

BAACC

Sample Output 1
3

Bruno

Sample Input 2
9

AAAABBBBB

Sample Output 2
4

Adrian

Bruno

Goran
*/

/*

//ONE TEST CASE NOT PASSING

import java.io.*;
import java.util.*;
public class A3_Ptice {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        char[] a = new char[3*n+1];
        for(int i=0; i<3*n; i+=3) {
            a[i]='A'; a[i+1]='B'; a[i+2]='C';
        }
        char[] b = new char[4*n+2];
        for(int i=0; i<4*n; i+=4) {
            b[i]='B';b[i+1]='A';b[i+2]='B';b[i+3]='C'; 
        }
        char[] g = new char[6*n+4];
        for(int i=0; i<6*n; i+=6) {
            g[i]='C';g[i+1]='C';g[i+2]='A';g[i+3]='A';g[i+4]='B';g[i+5]='B';
        }
        int acount=0, bcount=0, gcount=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==a[i]) acount++;
            if (s.charAt(i)==b[i]) bcount++;
            if (s.charAt(i)==g[i]) gcount++;
        }
        int max = Math.max(acount, Math.max(bcount, gcount));
        if (max==acount) {
            System.out.println(max+"\n"+"Adrian");
            if (max==bcount) System.out.println("Bruno");
            if (max==gcount) System.out.println("Goran");
        }
        else if (max==bcount) {
            System.out.println(max);
            if (max==acount) System.out.println("Adrian");
            System.out.println("Bruno");
            if (max==gcount) System.out.println("Goran");
        }
        else {
            System.out.println(max);
            if (max==acount) System.out.println("Adrian");
            if (max==bcount) System.out.println("Bruno");
            System.out.println("Bruno");
        }
        input.close();
    }
}
*/

import java.util.Scanner;

public class A3_Ptice {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), acount = 0, bcount = 0, gcount = 0;
        String cans = input.next(), aans = "ABC", bans = "BABC", gans = "CCAABB";
        for (int i = 0; i < n; i++) {
            if (cans.charAt(i) == aans.charAt(i % 3))
                acount++;
            if (cans.charAt(i) == bans.charAt(i % 4))
                bcount++;
            if (cans.charAt(i) == gans.charAt(i % 6))
                gcount++;
        }
        int max = Math.max(acount, Math.max(bcount, gcount));
        System.out.println(max);
        if (max == acount)
            System.out.println("Adrian");
        if (max == bcount)
            System.out.println("Bruno");
        if (max == gcount)
            System.out.println("Goran");
        input.close();
    }
}
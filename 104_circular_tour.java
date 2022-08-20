/*
Circular tour
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.

The amount of petrol that every petrol pump has.
Distance from that petrol pump to the next petrol pump. Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between. Note : Assume for 1 litre petrol, the truck can go 1 unit of distance.
Input
First line contains a single integer N denoting number of petrol pumps Next line contains N integers denoting petrol in each petrol pump Next line contains N integers denoting distance from petrol pump to next petrol pump

Output
Print the starting point where the truck can start to get through the complete circle without exhausting its petrol in between. Print -1 if no solution exist

Constraints:
2 <= N <= 10000 1 ≤ petrol, distance ≤ 1000

Sample Input:
4
4 6 7 4
6 5 3 5
Sample Output:
1
Explaination:
There are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output in this case is 1 (index of 2nd petrol pump).
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int petrol[] = new int[n];
      int distance[] = new int[n];
      for(int i = 0; i < n;i++) petrol[i] = sc.nextInt();
      for(int i = 0; i < n;i++) distance[i] = sc.nextInt();
 
      int totalPetrol = 0, totalDistance = 0;
      for(int i = 0; i < n;i++){
          totalPetrol += petrol[i];
          totalDistance += distance[i];
        }
 
      if(totalDistance > totalPetrol){
        System.out.println(-1);
        return;
      }
      int start = -1, i = 0, pet = 0;
      
      while(i != start){
         if(start == -1 && (petrol[i]) - distance[i]  >= 0){
           start =  i;
           pet += petrol[i] - distance[i];
           i = (i + 1) % n;
           continue;
         }
 
        if(start != -1 && pet + petrol[i] - distance[i] >= 0){
          pet += (petrol[i] - distance[i]);
          
        }
        else
        {
          start = -1;
          pet = 0;
        }
        i = (i + 1) % n;
      }
      System.out.println(start);
    }
}
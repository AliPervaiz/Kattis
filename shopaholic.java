import java.util.*;
import java.io.*;
import java.math.*;

public class shopaholic
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int[] ar = new int[N];
    for(int i = 0; i < N; i++)
      ar[i] = input.nextInt();
    Arrays.sort(ar);
    long sum = 0;
    for(int i = ar.length-3; i>=0; i-=3)
      sum += ar[i];
    System.out.println(sum);  
  }
}
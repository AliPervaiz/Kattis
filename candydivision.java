import java.util.*;
import java.io.*;
import java.math.*;

public class candydivision
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    long n = input.nextLong();
    String right = "";
    System.out.print(0);
    for(long i = 2; i < Math.sqrt(n); i++)
    {
      if(n%i==0)
      {
        System.out.print(" " + (i-1));
        StringBuilder sb = new StringBuilder(" "+(n/i-1));
        right += sb.reverse().toString();
      }
    }
    long i = Math.round(Math.sqrt(n));
    if(i*i==n) System.out.print(" " + (i-1));
    StringBuilder sb = new StringBuilder(right);
    System.out.print(sb.reverse());
    System.out.print(" " + (n-1));
  }
}
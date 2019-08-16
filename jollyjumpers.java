import java.util.*;
import java.io.*;
import java.math.*;

public class jollyjumpers
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt())
    {
      int n = input.nextInt();
      boolean[] ar = new boolean[n];
      int left = n-1;
      int f = input.nextInt();
      for(int i = 1; i < n; i++)
      {
        int b = input.nextInt();
        int diff = Math.abs(f-b);
        if(diff<ar.length&&!ar[diff])
        {
          left--;
          ar[diff] = true;
        }
        f = b;
      }
      if(left==0) System.out.println("Jolly");
      else System.out.println("Not jolly");
    }
  }
}
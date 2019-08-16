import java.util.*;
import java.io.*;
import java.math.*;

public class islands
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      int t = input.nextInt();
      int C = 0;
      int[] ar = new int[12];
      for(int i = 0; i < ar.length; i++)
        ar[i] = input.nextInt();
      for(int r = 1; r < ar.length-1; r++)
      {
        int min = ar[r];
        for(int c = r; c < ar.length-1; c++)
        {
          min = Math.min(min,ar[c]);
          if(min>ar[r-1]&&min>ar[c+1]) C++;
        }
      }
      System.out.println(t + " " + C);
    }
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class esej
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int A = input.nextInt();
    int B = input.nextInt();
    int count = Math.max(A,B/2+1);
    fam: for(char a = 'a'; a <= 'z'; a++)
    {
      for(char b = 'a'; b <= 'z'; b++)
      {
        for(char c = 'a'; c <= 'z'; c++)
        {
          for(char d = 'a'; d <= 'z'; d++)
          {
            System.out.print(""+a+b+c+d+" ");
            count--;
            if(count==0) break fam;
          }
        }
      }
    }
  }
}
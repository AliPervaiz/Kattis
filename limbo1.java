import java.util.*;
import java.io.*;
import java.math.*;

public class limbo1
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      long l = input.nextLong();
      long r = input.nextLong();
      long n = l+r;
      long f = (n)*(n+1)/2 + 1;
      long d = r-l;
      long fd = -l-r;
      long diff = (d-fd)/2;
      System.out.println(f+diff);
    }
  }
}
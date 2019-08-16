import java.util.*;
import java.io.*;
import java.math.*;

public class fractionallotion
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int[] dmap = new int[10001];
    for(int x = 2; x <= 20000; x++)
    {
      for(int n = x/2; n < Math.min(x,dmap.length); n++)
        if((long)x*n%(x-n)==0)
          if(n>=0&&n<dmap.length) dmap[n]++;
    }
    while(input.hasNext())
    {
      int n = Integer.parseInt(input.next().substring(2));
      System.out.println(dmap[n]);
    }
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class factstone
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt())
    {
      int year = input.nextInt();
      if(year==0) break;
      int bits = (int)Math.pow(2,(year/10-194));
      double[] fmap = new double[254018];
      for(int i = 1; i < fmap.length; i++)
      {
        fmap[i] = fmap[i-1]+Math.log(i)/Math.log(2);
        if(fmap[i]>bits)
        {
          System.out.println(i-1);
          break;
        }
      }
    }
  }
}
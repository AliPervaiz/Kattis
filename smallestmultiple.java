import java.util.*;
import java.io.*;
import java.math.*;

public class smallestmultiple
{
  public static BigInteger lcm(BigInteger a, BigInteger b)
  {
    return a.multiply(b).divide(a.gcd(b));
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    while(input.hasNextLine())
    {
      String[] line = input.nextLine().split(" ");
      BigInteger ans = new BigInteger(line[0]);
      for(int i = 1; i < line.length; i++)
        ans = lcm(ans,new BigInteger(line[i]));
      System.out.println(ans);  
    }  
  }
}
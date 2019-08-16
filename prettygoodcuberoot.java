import java.util.*;
import java.io.*;
import java.math.*;

public class prettygoodcuberoot
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line;
    while((line=input.readLine())!=null&&line.length()>0)
    {
      BigInteger n = new BigInteger(line);
      BigInteger f = BigInteger.ONE;
      BigInteger b = n;
      while(f.subtract(b).abs().compareTo(BigInteger.ONE)>0)
      {
        BigInteger mid = f.add(b).divide(new BigInteger("2"));
        if(mid.pow(3).equals(n))
        {
          f = mid;
          b = mid;
        }
        else if(mid.pow(3).compareTo(n)<0)
          f = mid.add(BigInteger.ONE);
        else
          b = mid.subtract(BigInteger.ONE);
      }
      BigInteger best = f.subtract(BigInteger.ONE);
      if(f.pow(3).subtract(n).abs().compareTo(best.pow(3).subtract(n).abs())<0) best = f;
      if(b.pow(3).subtract(n).abs().compareTo(best.pow(3).subtract(n).abs())<0) best = b;
      b = b.add(BigInteger.ONE);
      if(b.pow(3).subtract(n).abs().compareTo(best.pow(3).subtract(n).abs())<0) best = b;
      System.out.println(best);
    }
  }
}
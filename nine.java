import java.util.*;
import java.io.*;
import java.math.*;

public class nine
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      BigInteger p = new BigInteger(input.nextLong()-1+"");
      BigInteger mod = new BigInteger("1000000007");
      BigInteger ans = new BigInteger("9").modPow(p,mod);
      ans = ans.multiply(new BigInteger("8")).mod(mod);
      System.out.println(ans);
    }
  }
}
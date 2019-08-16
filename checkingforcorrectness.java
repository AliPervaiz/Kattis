import java.util.*;
import java.io.*;
import java.math.*;

public class checkingforcorrectness
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line;
    StringTokenizer st;
    while((line=input.readLine())!=null&&line.length()>0)
    {
      st = new StringTokenizer(line);
      long a = Long.parseLong(st.nextToken());
      char t = st.nextToken().charAt(0);
      long b = Long.parseLong(st.nextToken());
      if(t=='+')
        out.println((a+b)%10000);
      else if(t=='*')
      {
        a%=10000;
        b%=10000;
        out.println(a*b%10000);
      }
      else
      {
        BigInteger bi = new BigInteger(a+"");
        BigInteger bi2 = new BigInteger(b+"");
        BigInteger mod = new BigInteger("10000");
        out.println(bi.modPow(bi2,mod));
      }  
    }
    out.flush();
    out.close();
  }
}
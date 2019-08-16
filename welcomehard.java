import java.util.*;
import java.io.*;
import java.math.*;

public class welcomehard
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    input.nextLine();
    int t = 0;
    String s = "welcome to code jam";
    while(tc-->0)
    {
      t++;
      String line = input.nextLine();
      int[] dmap = new int[line.length()];
      for(int c = s.length()-1; c >= 0; c--)
      {
        int[] temp = new int[line.length()];
        int sum = 0;
        if(c==s.length()-1) sum = 1;
        for(int d = line.length()-1; d >= 0; d--)
        {
          sum += dmap[d]%10000;
          sum %= 10000;
          if(s.charAt(c)==line.charAt(d))
            temp[d] = sum%10000;
        }
        dmap = temp;
      }
      int sum = 0;
      for(int i : dmap) sum += i;
      System.out.printf("Case #%d: %04d%n",t,sum%10000);
    }
  }
}
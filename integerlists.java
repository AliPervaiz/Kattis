import java.util.*;
import java.io.*;
import java.math.*;

public class integerlists
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int tc = Integer.parseInt(input.readLine());
    while(tc-->0)
    {
      String s = input.readLine();
      int n = Integer.parseInt(input.readLine());
      String line = input.readLine();
      String[] ar = line.substring(1,line.length()-1).split(",");
      int f = 0;
      int b = ar.length-1;
      boolean front = true;
      int del = 0;
      for(int c = 0; c < s.length(); c++)
      {
        if(s.charAt(c)=='R') front = !front;
        else
        {
          del++;
          if(front) f++;
          else b--;
        }
      }
      if(f<=b)
      {
        if(front)
        {
          out.print("["+ar[f]);
          for(int i = f+1; i <= b; i++) out.print(","+ar[i]);
          out.println("]");
        }
        else
        {
          out.print("["+ar[b]);
          for(int i = b-1; i >= f; i--) out.print(","+ar[i]);
          out.println("]");
        }
      }
      else if(del==n) out.println("[]");
      else out.println("error");
    }
    out.flush();
    out.close();
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class rationalsequence
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      int t = input.nextInt();
      System.out.print(t + " ");
      String s = input.next();
      int a = Integer.parseInt(s.substring(0,s.indexOf("/")));
      int b = Integer.parseInt(s.substring(1+s.indexOf("/")));
      if(b==1) System.out.println(1+"/"+(a+1));
      else
      {
        int times = a/b;
        int topa = a-times*b;
        int topb = b;
        topb -= topa;
        topa += topb;
        topb += topa*times;
        System.out.println(topa+"/"+topb);
      }
    }
  }
}
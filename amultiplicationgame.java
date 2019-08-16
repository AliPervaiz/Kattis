import java.util.*;
import java.io.*;
import java.math.*;

public class amultiplicationgame
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    while(input.hasNextLong())
    {
      long n = input.nextLong();
      double d = n/18.0;
      long l = 1;
      boolean s = false;
      while(l<n)
      {
        s = !s;
        if(s) l*= 9;
        else l*= 2;
      }
      if(s) System.out.println("Stan wins.");
      else System.out.println("Ollie wins.");
    }
  }
}
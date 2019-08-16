import java.util.*;
import java.io.*;
import java.math.*;

public class artichoke
{
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      int p = input.nextInt();
      int a = input.nextInt();
      int b = input.nextInt();
      int c = input.nextInt();
      int d = input.nextInt();
      int n = input.nextInt();
      double max = Double.MIN_VALUE;
      double best = 0;
      for(int i = 1; i <= n; i++)
      {
        double ans = p*(2+Math.sin(a*i+b)+Math.cos(c*i+d));
        if(ans > max) max = ans;
        if(max-ans>best) best = max-ans;
      }
      System.out.println(best);
    }
}
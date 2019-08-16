import java.util.*;
import java.io.*;
import java.math.*;

public class goldbach2
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    boolean prime[] = new boolean[32001];
    Arrays.fill(prime,true);
    prime[0] = false;
    prime[1] = false;
    for(int r = 2; r < prime.length; r++)
      if(prime[r])
        for(int c = r*2; c < prime.length; c+=r)
          prime[c] = false;
    int tc = input.nextInt();
    while(tc-->0)
    {
      int n = input.nextInt();
      ArrayList<String> list = new ArrayList<String>();
      for(int i = 2; i <= n/2; i++)
        if(prime[i]&&prime[n-i])
          list.add(i+"+"+(n-i));
      System.out.println(n + " has " + list.size() + " representation(s)");
      for(String s : list) System.out.println(s);
      System.out.println();    
    }
  }
}
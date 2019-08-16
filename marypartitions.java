import java.util.*;
import java.io.*;
import java.math.*;

public class marypartitions
{
  public static int[][] dmap;
  public static ArrayList<Integer> coins;
  public static int rec(int i, int n)
  {
    if(i==coins.size()) return 0;
    if(n<0) return 0;
    if(n==0) return 1;
    if(dmap[i][n]!=-1) return dmap[i][n];
    return dmap[i][n] = rec(i,n-coins.get(i))+rec(i+1,n);
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      int t = input.nextInt();
      int m = input.nextInt();
      int n = input.nextInt();
      coins = new ArrayList<Integer>();
      int i = 0;
      while(Math.pow(m,i)<=n)
        coins.add((int)Math.pow(m,i++));
      dmap = new int[coins.size()][n+1];
      for(i = 0; i < dmap.length; i++)
        Arrays.fill(dmap[i],-1);
      System.out.println(t + " " + rec(0,n));  
    }
  }
}
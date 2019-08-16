import java.util.*;
import java.io.*;
import java.math.*;

public class cropeasy
{
  public static int choose(int n, int k)
  {
    k = Math.max(k,n-k);
    int num = 1;
    for(int i = k+1; i <= n; i++)
      num *= i;
    int den = 1;
    for(int i = 2; i <= n-k; i++)
      den *= i;
    return num/den;    
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    int t = 0;
    while(tc-->0)
    {
      t++;
      int n = input.nextInt();
      int A = input.nextInt();
      int B = input.nextInt();
      int C = input.nextInt();
      int D = input.nextInt();
      long X = input.nextInt();
      long Y = input.nextInt();
      int M = input.nextInt();
      int[][] dmap = new int[3][3];
      for(int i = 0; i < n; i++)
      {
        dmap[(int)(X%3)][(int)(Y%3)]++;
        X = (A*X+B)%M;
        Y = (C*Y+D)%M;
      }
      int sum = 0;
      for(int r = 0; r < 3; r++)
        for(int c = 0; c < 3; c++)
          if(dmap[r][c]>=3) 
            sum += choose(dmap[r][c],3);
      for(int r = 0; r < 3; r++)
      {
        int prod = dmap[r][0];
        for(int c = 1; c < 3; c++)
          prod *= dmap[r][c];
        sum += prod;  
      } 
      for(int c = 0; c < 3; c++)
      {
        int prod = dmap[0][c];
        for(int r = 1; r < 3; r++)
          prod *= dmap[r][c];
        sum += prod;  
      }
      for(int a = 0; a < 3; a++)
      {
        for(int b = 0; b < 3; b++)
        {
          for(int c = 0; c < 3; c++)
          {
            if(a==b||b==c||a==c) continue;
            sum += dmap[0][a]*dmap[1][b]*dmap[2][c];
          }
        }
      }
      System.out.printf("Case #%d: %d%n",t,sum);     
    }
  }
}

import java.util.*;
import java.io.*;
import java.math.*;

public class maximizingwinnings
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    while(true)
    {
      int n = Integer.parseInt(input.readLine());
      if(n==0) break;
      int[][] adj = new int[n][n];
      for(int r = 0; r < n; r++)
      {
        st = new StringTokenizer(input.readLine());
        for(int c = 0; c < n; c++)
          adj[r][c] = Integer.parseInt(st.nextToken());
      }
      int m = Integer.parseInt(input.readLine());
      int[][] maxDP = new int[n][m+1];
      int[][] minDP = new int[n][m+1];
      for(int c = 1; c < m+1; c++)
      {
        for(int r = 0; r < n; r++)
        {
          if(c == 1)
          {
            minDP[r][1] = adj[0][r];
            maxDP[r][1] = adj[0][r];
          }
          else
          {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int r2 = 0; r2 < n; r2++)
            {
              min = Math.min(min,minDP[r2][c-1]+adj[r2][r]);
              max = Math.max(max,maxDP[r2][c-1]+adj[r2][r]);
            }
            maxDP[r][c] = max;
            minDP[r][c] = min;
          }
        }
      }
      int min = minDP[0][m];
      int max = maxDP[0][m];
      for(int r = 1; r < n; r++)
      {
        min = Math.min(min,minDP[r][m]);
        max = Math.max(max,maxDP[r][m]);
      }
      out.println(max + " " + min);
    }  
    out.flush();
    out.close();
  }
}
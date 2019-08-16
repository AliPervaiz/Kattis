import java.util.*;
import java.io.*;
import java.math.*;

public class robotsonagrid
{
    public static char[][] grid;
    public static long[][] dp;
    public static boolean[][] visited;
    public static long f(int r, int c)
    {
        if(r<0||c<0||r>=grid.length||c>=grid.length) return 0;
        if(grid[r][c]=='#') return 0;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c] = (f(r+1,c)+f(r,c+1))%Integer.MAX_VALUE;
    }
    public static void flood(int r, int c)
    {
        if(r<0||c<0||r>=grid.length||c>=grid.length) return;
        if(grid[r][c]=='#') return;
        if(visited[r][c]) return;
        visited[r][c] = true;
        flood(r-1,c);
        flood(r+1,c);
        flood(r,c-1);
        flood(r,c+1);
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        grid = new char[n][n];
        dp = new long[n][n];
        for(int r = 0; r < n; r++)
        {
            String line = input.readLine();
            Arrays.fill(dp[r],-1);
            for(int c = 0; c < n; c++) grid[r][c] = line.charAt(c);
        }
        dp[n-1][n-1] = 1;
        if(f(0,0)==0)
        {
            visited = new boolean[n][n];
            flood(0,0);
            if(visited[n-1][n-1]) out.println("THE GAME IS A LIE");
            else out.println("INCONCEIVABLE");
        }
        else out.println(dp[0][0]);
        out.flush();
        out.close();
    }
}
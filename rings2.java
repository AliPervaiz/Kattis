import java.util.*;
import java.io.*;
import java.math.*;

public class rings2
{
    public static class Node
    {
        int r;
        int c;
        int d;
        public Node(int r, int c, int d)
        {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        Queue<Node> q = new LinkedList<Node>();
        int[][] dp = new int[n][m];
        for(int r = 0; r < n; r++)
        {
            String line = input.readLine();
            for(int c = 0; c < m; c++)
            {
                dp[r][c] = Integer.MAX_VALUE;
                grid[r][c] = line.charAt(c);
                if(grid[r][c]=='.')
                {
                    q.add(new Node(r,c,0));
                    dp[r][c] = 0;
                }
                else if(r==0||c==0||r==n-1||c==m-1)
                {
                    q.add(new Node(r,c,1));
                    dp[r][c] = 1;
                }
            }
        }
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int max = 0;
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(nod.d>dp[nod.r][nod.c]) continue;
            max = Math.max(max,nod.d);
            for(int d = 0; d < 4; d++)
            {
                int ro = nod.r + dr[d];
                int co = nod.c + dc[d];
                if(ro>=0&&co>=0&&ro<n&&co<m&&nod.d+1<dp[ro][co])
                {
                    dp[ro][co] = nod.d+1;
                    q.add(new Node(ro,co,dp[ro][co]));
                }
            }
        }
        int times = 2;
        if(max>=10) times = 3;
        for(int r = 0; r < n; r++)
        {
            for(int c = 0; c < m; c++)
            {
                String s = "";
                if(grid[r][c]=='T') s = dp[r][c]+"";
                while(s.length()<times) s = "."+s;
                out.print(s);
            }
            out.println();
        }
        out.flush();
        out.close();
    }
}
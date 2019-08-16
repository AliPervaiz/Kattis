import java.util.*;
import java.io.*;
import java.math.*;

public class grid
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
        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            String line = input.readLine();
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            for(int j = 0; j < m; j++) grid[i][j] = line.charAt(j)-'0';
        }
        Queue<Node> q = new LinkedList<Node>();
        dp[0][0] = 0;
        q.add(new Node(0,0,0));
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(nod.d>dp[nod.r][nod.c]) continue;
            if(nod.r==n-1&&nod.c==m-1) break;
            for(int dir = 0; dir < 4; dir++)
            {
                int ro = nod.r + dr[dir]*grid[nod.r][nod.c];
                int co = nod.c + dc[dir]*grid[nod.r][nod.c];
                if(ro>=0&&co>=0&&ro<n&&co<m&&nod.d+1<dp[ro][co])
                {
                    dp[ro][co] = nod.d+1;
                    q.add(new Node(ro,co,dp[ro][co]));
                }
            }
        }
        if(dp[n-1][m-1]==Integer.MAX_VALUE) out.println(-1);
        else out.println(dp[n-1][m-1]);
        out.flush();
        out.close();
    }
}
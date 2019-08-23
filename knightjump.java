import java.util.*;
import java.io.*;

public class knightjump
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
        int n = Integer.parseInt(input.readLine());
        char[][] map = new char[n][n];
        int[][] dp = new int[n][n];
        int kr = 0;
        int kc = 0;
        for(int r = 0; r < n; r++)
        {
            Arrays.fill(dp[r],Integer.MAX_VALUE);
            String line = input.readLine();
            for(int c = 0; c < n; c++)
            {
                map[r][c] = line.charAt(c);
                if(line.charAt(c)=='K')
                {
                    kr = r;
                    kc = c;
                }
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(kr,kc,0));
        dp[kr][kc] = 0;
        int[] dr = {1,1,-1,-1,2,2,-2,-2};
        int[] dc = {2,-2,2,-2,1,-1,1,-1};
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(nod.r==0&&nod.c==0) break;
            for(int d = 0; d < 8; d++)
            {
                int ro = nod.r + dr[d];
                int co = nod.c + dc[d];
                if(ro>=0&&co>=0&&ro<n&&co<n&&map[ro][co]!='#'&&1+nod.d<dp[ro][co])
                {
                    dp[ro][co] = nod.d+1;
                    q.add(new Node(ro,co,dp[ro][co]));
                }
            }
        }
        if(dp[0][0]==Integer.MAX_VALUE) out.println(-1);
        else out.println(dp[0][0]);
        out.flush();
        out.close();
    }
}
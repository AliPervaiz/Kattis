import java.util.*;
import java.io.*;
import java.math.*;

public class knightsearch
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
        String line = input.readLine();
        char[][] grid = new char[n][n];
        int in = 0;
        Queue<Node> q = new LinkedList<Node>();
        for(int r = 0; r < n; r++)
        {
            for(int c = 0; c < n; c++)
            {
                grid[r][c] = line.charAt(in++);
                if(grid[r][c]=='I') q.add(new Node(r,c,0));
            }
        }
        String fav = "ICPCASIASG";
        boolean found = false;
        int[] dr = {1,1,-1,-1,2,2,-2,-2};
        int[] dc = {2,-2,2,-2,1,-1,1,-1};
        boolean[][][] visited = new boolean[n][n][fav.length()];
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(visited[nod.r][nod.c][nod.d]) continue;
            visited[nod.r][nod.c][nod.d] = true;
            if(nod.d==fav.length()-1)
            {
                found = true;
                break;
            }
            for(int d = 0; d < dr.length; d++)
            {
                int ro = nod.r + dr[d];
                int co = nod.c + dc[d];
                if(ro>=0&&ro<n&&co>=0&&co<n&&grid[ro][co]==fav.charAt(nod.d+1)) q.add(new Node(ro,co,nod.d+1));
            }
        }
        if(found) out.println("YES");
        else out.println("NO");
        out.flush();
        out.close();
    }
}
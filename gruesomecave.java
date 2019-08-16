import java.util.*;
import java.io.*;

public class gruesomecave {
    public static class Node implements Comparable<Node>
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
        public int compareTo(Node nod)
        {
            return Integer.compare(d,nod.d);
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] dmap = new int[R][C];
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        for(int r = 0; r < R; r++)
        {
            Arrays.fill(dmap[r],Integer.MAX_VALUE);
            String line = input.readLine();
            for(int c = 0; c < line.length(); c++)
            {
                map[r][c] = line.charAt(c);
                if(map[r][c]=='E')
                {
                    sr = r;
                    sc = c;
                }
                if(map[r][c]=='D')
                {
                    er = r;
                    ec = c;
                }
            }
        }
        int[][] adj = new int[R][C];
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int total = 0;
        for(int r = 0; r < R; r++)
        {
            for(int c = 0; c < C; c++)
            {
                if(map[r][c] == ' ')
                {
                    int t = 0;
                    for(int d = 0; d < dr.length; d++)
                    {
                        int ro = r + dr[d];
                        int co = c + dc[d];
                        if(ro>=0&&co>=0&&ro<R&&co<C&&map[ro][co]==' ') t++;
                    }
                    adj[r][c] = t;
                    total += t;
                }
            }
        }
        dmap[sr][sc] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(sr,sc,0));
        while(!pq.isEmpty())
        {
            Node nod = pq.poll();
            if(nod.d>dmap[nod.r][nod.c]) continue;
            if(nod.r==er&&nod.c==ec) break;
            for(int d = 0; d < dr.length; d++)
            {
                int ro = nod.r + dr[d];
                int co = nod.c + dc[d];
                if(ro>=0&&co>=0&&ro<R&&co<C&&map[ro][co]!='#'&&nod.d+adj[ro][co]<dmap[ro][co])
                {
                    dmap[ro][co] = nod.d + adj[ro][co];
                    pq.add(new Node(ro,co,dmap[ro][co]));
                }
            }
        }
        out.println(1.0*dmap[er][ec]/total);
        out.flush();
        out.close();
    }
}

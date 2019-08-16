import java.util.*;
import java.io.*;
public class vuk
{
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
        public int compareTo(Node other)
        {
            return -Integer.compare(d,other.d);
        }
    }
    public static void main(String[] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        int R = input.nextInt();
        int C = input.nextInt();
        int[][] map = new int[R][C];
        int sr = -1;
        int sc = -1;
        int er = -1;
        int ec = -1;
        Queue<Node> q = new LinkedList<Node>();
        for(int r = 0; r < R; r++)
        {
            Arrays.fill(map[r],Integer.MAX_VALUE);
            String line = input.next();
            for(int c = 0; c < C; c++)
            {
                if(line.charAt(c)=='V')
                {
                    sr = r;
                    sc = c;
                }
                if(line.charAt(c)=='J')
                {
                    er = r;
                    ec = c;
                }
                if(line.charAt(c)=='+')
                {
                    map[r][c] = 0;
                    q.add(new Node(r,c,0));
                }
            }
        }
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(nod.d>map[nod.r][nod.c]) continue;
            for(int dir = 0; dir < dr.length; dir++)
            {
                int ro = nod.r + dr[dir];
                int co = nod.c + dc[dir];
                if(ro>=0&&co>=0&&ro<R&&co<C&&nod.d+1<map[ro][co])
                {
                    map[ro][co] = nod.d+1;
                    q.add(new Node(ro,co,nod.d+1));
                }
            }
        }
        boolean[][] bmap = new boolean[R][C];
        int min = map[sr][sc];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(sr,sc,map[sr][sc]));
        while(!pq.isEmpty())
        {
            Node nod = pq.poll();
            min = Math.min(min,nod.d);
            if(nod.r==er&&nod.c==ec) break;
            for(int dir = 0; dir < dr.length; dir++)
            {
                int ro = nod.r + dr[dir];
                int co = nod.c + dc[dir];
                if(ro>=0&&co>=0&&ro<R&&co<C&&!bmap[ro][co])
                {
                    bmap[ro][co] = true;
                    pq.add(new Node(ro,co,map[ro][co]));
                } 
            }
        }
        System.out.println(min);
    }
}
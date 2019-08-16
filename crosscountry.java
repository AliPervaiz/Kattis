import java.util.*;
import java.io.*;

public class crosscountry {
    public static class Node implements Comparable<Node>
    {
        int i;
        int d;
        public Node(int i, int d)
        {
            this.i = i;
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
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N][N];
        for(int r = 0; r < N; r++)
        {
            st = new StringTokenizer(input.readLine());
            for(int c = 0; c < N; c++)
                adj[r][c] = Integer.parseInt(st.nextToken());
        }
        int[] dmap = new int[N];
        Arrays.fill(dmap,Integer.MAX_VALUE);
        dmap[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(S,0));
        while(!pq.isEmpty())
        {
            Node nod = pq.poll();
            if(nod.d>dmap[nod.i]) continue;
            if(nod.i==T)
            {
                out.println(nod.d);
                out.flush();
                out.close();
                break;
            }
            for(int j = 0; j < N; j++)
            {
                if(j!=nod.i&&nod.d+adj[nod.i][j]<dmap[j])
                {
                    dmap[j] = nod.d + adj[nod.i][j];
                    pq.add(new Node(j,dmap[j]));
                }
            }
        }
    }
}

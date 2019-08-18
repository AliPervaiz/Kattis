import java.util.*;
import java.io.*;

public class treehouses
{
    public static class Node implements Comparable<Node>
    {
        int i;
        double d;
        public Node(int i, double d)
        {
            this.i = i;
            this.d = d;
        }
        public int compareTo(Node o)
        {
            return Double.compare(d,o.d);
        }
    }
    public static double dist(double a, double b, double c, double d)
    {
        return Math.sqrt(Math.pow(c-a,2)+Math.pow(d-b,2));
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        double[] x = new double[n];
        double[] y = new double[n];
        boolean[] connected = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int N = 0;
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(input.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
            if(i<e) pq.add(new Node(i,0));
        }
        boolean[][] adj = new boolean[n][n];
        for(int i = 0; i < p; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a][b] = true;
            adj[b][a] = true;
        }
        double cost = 0;
        while(N!=n)
        {
            Node nod = pq.poll();
            if(connected[nod.i]) continue;
            connected[nod.i] = true;
            N++;
            cost += nod.d;
            for(int j = 0; j < n; j++)
            {
                if(!connected[j])
                {
                    if(adj[nod.i][j]) pq.add(new Node(j,0));
                    else pq.add(new Node(j,dist(x[nod.i],y[nod.i],x[j],y[j])));
                }
            }
        }
        out.println(cost);
        out.flush();
        out.close();
    }
}
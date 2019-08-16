import java.util.*;
import java.io.*;
import java.math.*;

public class lost
{
    public static class Node implements Comparable<Node>
    {
        int i;
        int d;
        int wd;
        public Node(int i, int d, int wd)
        {
            this.i = i;
            this.d = d;
            this.wd = wd;
        }
        public int compareTo(Node o)
        {
            if(d==o.d) return Integer.compare(wd,o.wd);
            return Integer.compare(d,o.d);
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> langs = new ArrayList<String>();
        langs.add("English");
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) langs.add(st.nextToken());
        int[][] adj = new int[n+1][n+1];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = langs.indexOf(st.nextToken());
            int b = langs.indexOf(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a][b] = w;
            adj[b][a] = w;
        }
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0,0,0));
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty())
        {
            Node nod = pq.poll();
            if(visited[nod.i]) continue;
            visited[nod.i] = true;
            sum += nod.wd;
            count++;
            if(count==n+1) break;
            for(int j = 0; j <= n; j++) if(!visited[j]&&adj[nod.i][j]!=0) pq.add(new Node(j,nod.d+1,adj[nod.i][j]));
        }
        if(count==n+1) out.println(sum);
        else out.println("Impossible");
        out.flush();
        out.close();
    }
}
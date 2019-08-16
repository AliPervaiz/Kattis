import java.util.*;
import java.io.*;
import java.math.*;

public class visualgo
{
    public static class Node implements Comparable<Node>
    {
        int i;
        int d;
        public Node(int i, int d)
        {
            this.i = i;
            this.d = d;
        }
        public int compareTo(Node o)
        {
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
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(a).add(w);
        }
        st = new StringTokenizer(input.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] paths = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        paths[s] = 1;
        dp[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(s,0));
        while(!pq.isEmpty())
        {
            Node nod = pq.poll();
            if(nod.i==t) break;
            for(int i = 0; i < adj.get(nod.i).size(); i+=2)
            {
                int j = adj.get(nod.i).get(i);
                int w = adj.get(nod.i).get(i+1);
                if(nod.d+w<dp[j])
                {
                    paths[j] = paths[nod.i];
                    dp[j] = nod.d+w;
                    pq.add(new Node(j,dp[j]));
                }
                else if(nod.d+w==dp[j]) paths[j] += paths[nod.i];
            }
        }
        out.println(paths[t]);
        out.flush();
        out.close();
    }
}
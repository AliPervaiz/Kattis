import java.util.*;
import java.io.*;
import java.math.*;

public class maximizingyourpay
{
    public static class Node
    {
        int i;
        int d;
        int b;
        public Node(int i, int d, int b)
        {
            this.i = i;
            this.d = d;
            this.b = b;
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            int m = Integer.parseInt(st.nextToken());
            boolean[][] adj = new boolean[n][n];
            for(int i = 0; i < m; i++)
            {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = true;
                adj[b][a] = true;
            }
            int best = 1;
            Queue<Node> q = new LinkedList<Node>();
            q.add(new Node(0,1,1));
            int counter = 0;
            HashMap<Integer,HashSet<Integer>> dp = new HashMap<Integer,HashSet<Integer>>();
            for(int i = 0; i < n; i++) dp.put(i,new HashSet<Integer>());
            while(!q.isEmpty())
            {
                Node nod = q.poll();
                if(adj[nod.i][0]&&nod.d>best) best = nod.d;
                if(dp.get(nod.i).contains(nod.b)) continue;
                dp.get(nod.i).add(nod.b);
                counter++;
                for(int j = 0; j < n; j++)
                    if(nod.i!=j&&adj[nod.i][j]&&(nod.b&(int)Math.pow(2,j))==0)
                        q.add(new Node(j,nod.d+1,nod.b+(int)Math.pow(2,j)));
            }
            out.println(best);
        }
        out.flush();
        out.close();
    }
}
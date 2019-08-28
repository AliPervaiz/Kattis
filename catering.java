import java.util.*;
import java.io.*;

public class catering 
{
    public static int N;
    public static boolean[] found;
    public static int[][] flow;
    public static int[] dist;
    public static int[] dad;
    public static int[] pi;
    public static int[][] cost;
    public static int[][] cap;
    public static int INF = Integer.MAX_VALUE/2+1;
    public static boolean search(int source, int sink)
    {
        Arrays.fill(found, false);
        Arrays.fill(dist, INF);
        dist[source] = 0;
        while (source != N) 
        {
            int best = N;
            found[source] = true;
            for (int k = 0; k < N; k++) 
            {
                if (found[k]) continue;
                if (flow[k][source] != 0) 
                {
                    int val = dist[source] + pi[source] - pi[k] - cost[k][source];
                    if (dist[k] > val) 
                    {
                        dist[k] = val;
                        dad[k] = source;
                    }
                }
                if (flow[source][k] < cap[source][k]) 
                {
                    int val = dist[source] + pi[source] - pi[k] + cost[source][k];
                    if (dist[k] > val) 
                    {
                        dist[k] = val;
                        dad[k] = source;
                    }
                }
                if (dist[k] < dist[best]) best = k;
            }
            source = best;
        }
        for (int k = 0; k < N; k++) pi[k] = Math.min(pi[k] + dist[k], INF);
        return found[sink];
    }
    public static int getMaxFlow(int source, int sink) 
    {
        int tcost = 0;
        while (search(source, sink)) 
        {
            int amt = INF;
            for (int x = sink; x != source; x = dad[x])
            amt = Math.min(amt, flow[x][dad[x]] != 0 ? flow[x][dad[x]] : cap[dad[x]][x] - flow[dad[x]][x]);
            for (int x = sink; x != source; x = dad[x]) 
            {
                if (flow[x][dad[x]] != 0) 
                {
                    flow[x][dad[x]] -= amt;
                    tcost -= amt * cost[x][dad[x]];
                } 
                else 
                {
                    flow[dad[x]][x] += amt;
                    tcost += amt * cost[dad[x]][x];
                }
            }
        }
        return tcost;
    }
    public static void main (String args[]) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        cap = new int[2*n+2][2*n+2];
        for(int i = 1; i <= n; i++) cap[0][i] = 1;
        for(int i = 1; i <= n; i++) for(int j = 1; j <= i; j++) cap[i][j+n] = 1;
        cap[n+1][2*n+1] = k;
        for(int i = n+2; i <= 2*n; i++) cap[i][2*n+1] = 1;
        N = cap.length;
        found = new boolean[N];
        flow = new int[N][N];
        dist = new int[N+1];
        dad = new int[N];
        pi = new int[N];
        cost = new int[N][N];
        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(input.readLine());
            for(int j = i; j <= n; j++) cost[j][i+n] = Integer.parseInt(st.nextToken());
        }
        out.println(getMaxFlow(0, 2*n+1));
        out.flush();
        out.close();
    }
}
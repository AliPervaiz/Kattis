import java.util.*;
import java.io.*;

public class hoppers
{
    public static ArrayList<ArrayList<Integer>> adjList;
    public static int[] dist;
    public static boolean needed = true;
    public static void dfs(int i, int d)
    {
        dist[i] = d;
        for(int j : adjList.get(i))
        {
            if(dist[j]==0) dfs(j,d+1);
            else if(Math.abs(dist[i]-dist[j])%2==0) needed = false;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        adjList = new ArrayList<ArrayList<Integer>>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        for(int i = 0; i < N; i++) adjList.add(new ArrayList<Integer>());
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        int requests = -1;
        for(int i = 0; i < N; i++)
        {
            if(dist[i]==0)
            {
                dfs(i,1);
                requests++;
            }
        }
        if(needed) requests++;
        out.println(requests);
        out.flush();
        out.close();
    }
}
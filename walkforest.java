import java.util.*;
import java.io.*;
import java.math.*;

public class walkforest
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
    public int compareTo(Node other)
    {
      return Integer.compare(d,other.d);
    }
  }
  public static int[] dmap;
  public static int[] dmap2;
  public static int[][] adj;
  public static int rec(int i)
  {
    if(dmap2[i]!=-1) return dmap2[i];
    if(dmap[i]==0) return dmap2[i] = 1;
    int sum = 0;
    for(int j = 1; j < adj.length; j++)
      if(adj[i][j]!=0&&dmap[j]<dmap[i])
        sum += rec(j);
    return dmap2[i] = sum;    
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while(true)
    {
      st = new StringTokenizer(input.readLine());
      int N = Integer.parseInt(st.nextToken());
      if(N==0) break;
      int M = Integer.parseInt(st.nextToken());
      adj = new int[N+1][N+1];
      for(int i = 0; i < M; i++)
      {
        st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        adj[a][b] = d;
        adj[b][a] = d;
      }
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      pq.add(new Node(2,0));
      dmap = new int[N+1];
      Arrays.fill(dmap,Integer.MAX_VALUE);
      dmap[2] = 0;
      int times1 = 0;
      while(!pq.isEmpty())
      {
        Node nod = pq.poll();
        if(nod.d>dmap[nod.i]) continue;
        times1++;
        for(int i = 1; i <= N; i++)
        {
          if(adj[i][nod.i]!=0&&nod.d+adj[i][nod.i]<dmap[i])
          {
            pq.add(new Node(i,nod.d+adj[i][nod.i]));
            dmap[i] = nod.d+adj[i][nod.i];
          }
        }
      }
      dmap2 = new int[N+1];
      Arrays.fill(dmap2,-1);
      System.out.println(rec(1));
    }
  }
}
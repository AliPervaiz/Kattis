import java.util.*;
import java.io.*;
import java.math.*;

public class bigtruck
{
    public static class Node implements Comparable<Node>
    {
      int i;
      int d;
      int s;
      public Node(int i, int d, int s)
      {
        this.i = i;
        this.d = d;
        this.s = s;
      }
      public int compareTo(Node nod)
      {
        if(d==nod.d)
          return new Integer(nod.s).compareTo(s);
        return new Integer(d).compareTo(nod.d);  
      }
    }
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int[] itemAr = new int[n+1];
      for(int i = 1; i <= n; i++)
        itemAr[i] = input.nextInt();
      int m = input.nextInt();
      int[][] adj = new int[n+1][n+1];
      for(int i = 0; i < m; i++)
      {
        int a = input.nextInt();
        int b = input.nextInt();
        int d = input.nextInt();
        adj[a][b] = d;
        adj[b][a] = d;
      }  
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      int[] dmap = new int[n+1];
      Arrays.fill(dmap,Integer.MAX_VALUE);
      pq.add(new Node(1,0,itemAr[1]));
      boolean found = false;
      while(!pq.isEmpty())
      {
        Node nod = pq.poll();
        if(nod.i==n)
        {
          found = true;
          System.out.println(nod.d + " " + nod.s);
          break;
        }
        if(nod.d>=dmap[nod.i]) continue;
        dmap[nod.i] = nod.d;
        for(int i = 1; i <= n; i++)
          if(adj[nod.i][i]!=0&&nod.d+adj[nod.i][i]<dmap[i])
            pq.add(new Node(i,nod.d+adj[nod.i][i],nod.s+itemAr[i]));
      }
      if(!found) System.out.println("impossible");
    }
}
import java.util.*;
import java.io.*;
public class shortestpath1 {
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
      return new Integer(d).compareTo(nod.d);
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt())
    {
      int n = input.nextInt();
      if(n==0) break;
      int e = input.nextInt();
      int q = input.nextInt();
      int s = input.nextInt();
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
      for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
      for(int i = 0; i < e; i++)
      {
        int source = input.nextInt();
        adj.get(source).add(input.nextInt());
        adj.get(source).add(input.nextInt());
      }
      int[] dmap = new int[n];
      Arrays.fill(dmap,Integer.MAX_VALUE);
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      pq.add(new Node(s,0));
      while(!pq.isEmpty())
      {
        Node nod = pq.poll();
        if(nod.d>dmap[nod.i]) continue;
        dmap[nod.i] = nod.d;
        for(int i = 0; i < adj.get(nod.i).size(); i+=2)
        {
          int next = adj.get(nod.i).get(i);
          int dist = adj.get(nod.i).get(i+1);
          if(nod.d+dist<dmap[next])
          {
            pq.add(new Node(next,nod.d+dist));
            dmap[next] = nod.d+dist;
          }
        }
      }
      for(int i = 0; i < q; i++)
      {
        int next = input.nextInt();
        if(dmap[next]==Integer.MAX_VALUE) System.out.println("Impossible");
        else System.out.println(dmap[next]);
      }
      System.out.println();
    }
  }  
}
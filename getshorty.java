import java.util.*;
import java.io.*;
public class getshorty {
  public static class Node implements Comparable<Node>
  {
    int i;
    double d;
    public Node(int i, double d)
    {
      this.i = i;
      this.d = d;
    }
    public int compareTo(Node nod)
    {
      return new Double(d).compareTo(nod.d)*-1;
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt())
    {
      int nodes = input.nextInt();
      int edges = input.nextInt();
      if(nodes==0) break;
      ArrayList<ArrayList<Double>> adj = new ArrayList<ArrayList<Double>>();
      for(int i = 0; i < nodes; i++) adj.add(new ArrayList<Double>());
      for(int e = 0; e < edges; e++)
      {
        int s = input.nextInt();
        int d = input.nextInt();
        double w = input.nextDouble();
        adj.get(s).add(1.0*d);
        adj.get(s).add(w);
        adj.get(d).add(1.0*s);
        adj.get(d).add(w);
      }
      PriorityQueue<Node> pq = new PriorityQueue<Node>();
      double[] dmap = new double[nodes];
      pq.add(new Node(0,1));
      while(!pq.isEmpty())
      {
        Node nod = pq.poll();
        if(nod.d<=dmap[nod.i]) continue;
        dmap[nod.i] = nod.d;
        for(int i = 0; i < adj.get(nod.i).size(); i+=2)
        {
          double n = adj.get(nod.i).get(i);
          int next = (int)n;
          double dist = adj.get(nod.i).get(i+1);
          if(dist*nod.d>dmap[next])
            pq.add(new Node(next,dist*nod.d));
        }    
      }
      System.out.printf("%.4f%n",dmap[dmap.length-1]);
    }
  }  
}
import java.util.*;
import java.io.*;
import java.math.*;

public class robotturtles
{
  public static class Node implements Comparable<Node>
  {
    int r;
    int c;
    int i;
    String p;
    public Node(int r, int c, int i, String p)
    {
      this.r = r;
      this.c = c;
      this.i = i;
      this.p = p;
    }
    public int compareTo(Node other)
    {
      return Integer.compare(p.length(),other.p.length());
    }
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    char[][] map = new char[8][8];
    int[][][] dmap = new int[8][8][4];
    for(int r = 0; r < 8; r++)
    {
      String line = input.next();
      for(int c = 0; c < 8; c++)
      {
        Arrays.fill(dmap[r][c],Integer.MAX_VALUE);
        map[r][c] = line.charAt(c);
      }
    }
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    pq.add(new Node(7,0,0,""));
    boolean found = false;
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    while(!pq.isEmpty())
    {
      Node nod = pq.poll();
      if(nod.p.length()>=dmap[nod.r][nod.c][nod.i]) continue;
      dmap[nod.r][nod.c][nod.i] = nod.p.length();
      if(map[nod.r][nod.c]=='D')
      {
        found = true;
        System.out.println(nod.p);
        break;
      }
      int nextI = (nod.i+5)%4;
      if(nod.p.length()+1<dmap[nod.r][nod.c][nextI])
        pq.add(new Node(nod.r,nod.c,nextI,nod.p+"R"));
      nextI = (nod.i+3)%4;
      if(nod.p.length()+1<dmap[nod.r][nod.c][nextI])
        pq.add(new Node(nod.r,nod.c,nextI,nod.p+"L"));
      int ro = nod.r + dr[nod.i];
      int co = nod.c + dc[nod.i];
      if(ro>=0&&co>=0&&ro<8&&co<8)
      {
        if(map[ro][co]=='I'&&nod.p.length()+2<dmap[ro][co][nod.i])
          pq.add(new Node(ro,co,nod.i,nod.p+"XF"));
        if(".D".contains(""+map[ro][co])&&nod.p.length()+1<dmap[ro][co][nod.i])
          pq.add(new Node(ro,co,nod.i,nod.p+"F"));  
      }    
    }
    if(!found) System.out.println("no solution");
  }
}
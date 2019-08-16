import java.util.*;
import java.io.*;
import java.math.*;

public class fire2
{
  public static class Node
  {
    int r;
    int c;
    int d;
    public Node(int r, int c, int d)
    {
      this.r = r;
      this.c = c;
      this.d = d;
    }
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      int C = input.nextInt();
      int R = input.nextInt();
      char[][] map = new char[R][C];
      int[][] fmap = new int[R][C];
      int[][] dmap = new int[R][C];
      Queue<Node> q = new LinkedList<Node>();
      int sr = -1;
      int sc = -1;
      for(int r = 0; r < R; r++)
      {
        String line = input.next();
        Arrays.fill(fmap[r],Integer.MAX_VALUE);
        Arrays.fill(dmap[r],Integer.MAX_VALUE);
        for(int c = 0; c < C; c++)
        {
          map[r][c] = line.charAt(c);
          if(map[r][c]=='*')
          {
            fmap[r][c] = 0;
            q.add(new Node(r,c,0));
          }
          if(map[r][c]=='@')
          {
            sr = r;
            sc = c;
            dmap[r][c] = 0;
          }
        }
      }
      int[] dr = {1,-1,0,0};
      int[] dc = {0,0,1,-1};
      while(!q.isEmpty())
      {
        Node nod = q.poll();
        if(nod.d>fmap[nod.r][nod.c]) continue;
        for(int dir = 0; dir < dr.length; dir++)
        {
          int ro = nod.r + dr[dir];
          int co = nod.c + dc[dir];
          if(ro>=0&&co>=0&&ro<R&&co<C&&map[ro][co]!='#'&&1+nod.d<fmap[ro][co]
          )
          {
            fmap[ro][co] = 1+nod.d;
            q.add(new Node(ro,co,1+nod.d));
          }
        }
      }
      q = new LinkedList<Node>();
      q.add(new Node(sr,sc,0));
      boolean poss = false;
      fam: while(!q.isEmpty())
      {
        Node nod = q.poll();
        if(nod.d>dmap[nod.r][nod.c]) continue;
        for(int dir = 0; dir < dr.length; dir++)
        {
          int ro = nod.r + dr[dir];
          int co = nod.c + dc[dir];
          if(ro>=0&&co>=0&&ro<R&&co<C&&map[ro][co]!='#'&&1+nod.d<dmap[ro][co]&&1+nod.d<fmap[ro][co]
          )
          {
            dmap[ro][co] = 1+nod.d;
            q.add(new Node(ro,co,1+nod.d));
          }
          if(ro<0||co<0||ro>=R||co>=C)
          {
            System.out.println(1+nod.d);
            poss = true;
            break fam;
          }
        }
      }
      if(!poss) System.out.println("IMPOSSIBLE");
    }
  }
}
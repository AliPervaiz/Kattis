import java.util.*;
import java.io.*;
import java.math.*;

public class rockclimbing
{
  public static int[][] map;
  public static int[][] dmap;
  public static void rec(int r, int c, int d)
  {
    if(r<0||c<0||r>=map.length||c>=map[0].length) return;
    d += map[r][c];
    d = Math.max(d,0);
    if(d>=dmap[r][c]) return;
    dmap[r][c] = d;
    rec(r+1,c,d);
    rec(r-1,c,d);
    rec(r,c+1,d);
    rec(r,c-1,d);
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int R = input.nextInt();
    int C = input.nextInt();
    for(int i = 0; i < C; i++) input.next();
    map = new int[R+2][C];
    dmap = new int[R+2][C];
    for(int r = 0; r < R+2; r++)
    {
      for(int c = 0; c < C; c++)
      {
        if(r==0||r==R+1) map[r][c] = 0;
        else map[r][c] = input.nextInt();
        dmap[r][c] = Integer.MAX_VALUE;
      }
    }
    for(int c = 0; c < C; c++) rec(0,c,0);
    int min = dmap[R+1][0];
    for(int c = 1; c < C; c++) min = Math.min(min,dmap[R+1][c]);
    System.out.println(min);
  }
}
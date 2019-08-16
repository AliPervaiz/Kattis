import java.util.*;
import java.io.*;
import java.math.*;

public class countingstars
{
    public static char[][] map;
    public static boolean[][] bmap;
    public static void rec(int r, int c)
    {
      if(r<0||c<0||r>=map.length||c>=map[0].length)
        return;
      if(map[r][c]!='-') return;
      if(bmap[r][c]) return;
      bmap[r][c] = true;
      rec(r-1,c);
      rec(r+1,c);  
      rec(r,c-1);
      rec(r,c+1);
    }
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      int t = 0;
      while(input.hasNextInt())
      {
        t++;
        int rows = input.nextInt();
        int cols = input.nextInt();
        map = new char[rows][cols];
        bmap = new boolean[rows][cols];
        for(int r = 0; r < rows; r++)
          map[r] = input.next().toCharArray();
        int ans = 0;
        for(int r = 0; r < rows; r++)
        {
          for(int c = 0; c < cols; c++)
          {
            if(map[r][c]=='-'&&!bmap[r][c])
            {
              ans++;
              rec(r,c);
            }
          }
        }
        System.out.printf("Case %d: %d%n",t,ans);
      }
    }
}
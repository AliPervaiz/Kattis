import java.util.*;
import java.io.*;
import java.math.*;

public class turtlemaster
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    char[][] map = new char[8][8];
    int rd = -1;
    int cd = -1;
    for(int r = 0; r < 8; r++)
    {
      String line = input.next();
      for(int c = 0; c < 8; c++)
      {
        map[r][c] = line.charAt(c);
        if(map[r][c]=='D')
        {
          rd = r;
          cd = c;
        }
      }
    }
    int R = 7;
    int C = 0;
    String s = input.next();
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    int index = 0;
    boolean bug = false;
    for(int c = 0; c < s.length(); c++)
    {
      if(s.charAt(c)=='R')
        index = (index+5)%4;
      else if(s.charAt(c)=='L')
        index = (index+3)%4;
      else if(s.charAt(c)=='F')
      {
        int ro = R + dr[index];
        int co = C + dc[index];
        if(ro<0||co<0||ro>=8||co>=8||map[ro][co]=='I'||map[ro][co]=='C')
        {
          bug = true;
          break;
        }
        R = ro;
        C = co;
      }
      else
      {
        int ro = R + dr[index];
        int co = C + dc[index];
        if(ro<0||co<0||ro>=8||co>=8||map[ro][co]!='I')
        {
          bug = true;
          break;
        }
        map[ro][co] = '.';
      }    
    }
    if(R!=rd||C!=cd||bug) System.out.print("Bug!");
    else System.out.print("Diamond!");
  }
}

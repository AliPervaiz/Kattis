import java.util.*;
import java.io.*;
public class eightqueens {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char[][] map = new char[8][8];
    for(int r = 0; r < 8; r++) map[r] = input.next().toCharArray();
    boolean works = true;
    int queens = 0;
    fam:for(int r = 0; r < 8; r++)
    {
      for(int c = 0; c < 8; c++)
      {
        if(map[r][c]=='*')
        {
          queens++;
          int[] dr = {1,1,1,0,0,-1,-1,-1};
          int[] dc = {1,0,-1,1,-1,1,-1,0};
          for(int times = 1; times < 8; times++)
          {
              for(int dir = 0; dir < dr.length; dir++)
              {
                int ro = r + dr[dir]*times;
                int co = c + dc[dir]*times;
                if(ro>=0&&co>=0&&ro<8&&co<8&&map[ro][co]=='*')
                {
                  works = false;
                  break fam;
                }
              }
          }
        }
      }
    }
    if(works&&queens==8) System.out.print("valid");
    else System.out.print("invalid");
  }  
}
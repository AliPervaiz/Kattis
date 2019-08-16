import java.util.*;
import java.io.*;
public class grille {
  public static void rotate(char[][] array)
  {
    for (int i = 0; i < array.length; i++ )
    {
        for (int j = i + 1; j < array.length; j++ )
        {
            char tmp = array[i][j];
            array[i][j] = array[j][i];
            array[j][i] = tmp;
        }
    }
    for (int i = 0; i < array.length; i++)
    {
        for (int j = 0; j < array.length / 2; j++)
        {
            char tmp = array[i][j];
            array[i][j] = array[i][array.length - 1 - j];
            array[i][array.length - 1 - j] = tmp;
        }
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[][] map = new char[n][n];
    char[][] grille = new char[n][n];
    int index = 0;
    for(int r = 0; r < n; r++)
    {
      String line = input.next();
      for(int c = 0; c < n; c++)
        grille[r][c] = line.charAt(c);
    }
    String encrypt = input.next();
    boolean valid = true;
    fam:for(int i = 0; i < 4; i++)
    {
      for(int r = 0; r < n; r++)
      {
        for(int c = 0; c < n; c++)
        {
          if(grille[r][c]=='.')
          {
            if(map[r][c]!=0)
            {
              valid = false;
              break fam;
            }
            else
              map[r][c] = encrypt.charAt(index++);
          }
        }
      }
      rotate(grille);
    }
    if(!valid||index!=n*n)
      System.out.println("invalid grille");
    else
    {
      for(int r = 0; r < n; r++)
        for(int c = 0; c < n; c++)
          System.out.print(map[r][c]);
    }  
    
  }
}
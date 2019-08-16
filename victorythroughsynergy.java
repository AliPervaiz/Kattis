import java.util.*;
import java.io.*;
import java.math.*;

public class victorythroughsynergy
{
  public static boolean done;
  public static boolean[][] adj;
  public static HashMap<Integer,String[]> map;
  public static int[] max;
  public static void rec(String s)
  {
    if(done) return;
    for(int i = 0; i < s.length(); i++)
    {
      int I = Integer.parseInt(""+s.charAt(i));
      if(max[i]==s.length()-1||i==s.length()-1&&max[i]<s.length())
      {
        int syn = 0;
        int links = 0;
        for(int c = 0; c <= max[i]; c++)
        {
          int C = Integer.parseInt(""+s.charAt(c));
          if(adj[i][c])
          {
            int temp = 0;
            String[] one = map.get(I);
            String[] two = map.get(C);
            if(one[1].equals(two[1])) temp = 1;
            if(one[2].equals(two[2])) temp = 1;
            if(one[3].equals(two[3])) temp = 2;
            if(one[1].equals(two[1])&&one[2].equals(two[2])) temp = 2;
            if(one[1].equals(two[1])&&one[3].equals(two[3])) temp = 3;
            syn += temp;
            links++;
          }
        }
        if(syn<links) return;
      }
    }
    if(s.length()==10)
    {
      //System.out.println(s);
      done = true;
      return;
    }
    for(int i = 0; i < 10; i++)
      if(!s.contains(i+""))
        rec(s + i);
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    adj = new boolean[10][10];
    map = new HashMap<Integer,String[]>();
    max = new int[10];
    int c = input.nextInt();
    for(int i = 0; i < c; i++)
    {
      int a = input.nextInt();
      int b = input.nextInt();
      adj[a][b] = true;
      adj[b][a] = true;
      if(b>max[a]) max[a] = b;
      if(a>max[b]) max[b] = a;
    }
    input.nextLine();
    for(int i = 0; i < 10; i++)
      map.put(i,input.nextLine().split(" "));
    done = false;
    rec("");
    if(done) System.out.println("yes");
    else System.out.println("no");
  }
}
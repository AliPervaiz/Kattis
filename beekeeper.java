import java.util.*;
import java.io.*;

public class beekeeper {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String vow = "aeiouy";
    while(true)
    {
      int n = Integer.parseInt(input.readLine());
      if(n==0) break;
      int best = -1;
      String winner = "";
      for(int i = 0; i < n; i++)
      {
        String s = input.readLine();
        int count = 0;
        for(int c = 0; c < s.length()-1; c++) if(vow.contains(s.charAt(c)+"")&&s.charAt(c+1)==s.charAt(c)) count++;
        if(count>best)
        {
          best = count;
          winner = s;
        }
      }
      out.println(winner);
    }
    out.flush();
    out.close();
  }
}
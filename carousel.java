import java.util.*;
import java.io.*;

public class carousel {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    while(true)
    {
      StringTokenizer st = new StringTokenizer(input.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      if(n==0) break;
      int bestN = -1;
      int bestD = 1;
      for(int i = 0; i < n; i++)
      {
        st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        if(N<=m&&N*bestD>D*bestN || N<=m&&N*bestD==D*bestN&&N>bestN)
        {
          bestN = N;
          bestD = D;
        }
      }
      if(bestN == -1) out.println("No suitable tickets offered");
      else out.println("Buy " + bestN + " tickets for $" + bestD);
    }  
    out.flush();
    out.close();
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class pachinkoprobability
{
  public static HashMap<Integer,ArrayList<Integer>> adj;
  public static long[] dmap;
  public static long rec(int i)
  {
    if(dmap[i]!=-1) return dmap[i];
    if(!adj.containsKey(i)) return dmap[i] = 1;
    long sum = 0;
    for(int j : adj.get(i)) sum += rec(j);
    return dmap[i] = sum;
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    int N = Integer.parseInt(input.readLine());
    adj = new HashMap<Integer,ArrayList<Integer>>();
    int M = Integer.parseInt(input.readLine());
    boolean[] isNotEnd = new boolean[N];
    for(int i = 0; i < M; i++)
    {
      st = new StringTokenizer(input.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if(!adj.containsKey(y)) adj.put(y,new ArrayList<Integer>());
      adj.get(y).add(x);
      isNotEnd[x] = true;
    }
    long winning = 0;
    long total = 0;
    dmap = new long[N];
    Arrays.fill(dmap,-1);
    int K = Integer.parseInt(input.readLine());
    for(int i = 0; i < K; i++)
      winning += rec(Integer.parseInt(input.readLine()));
    for(int i = 0; i < N; i++)
      if(!isNotEnd[i])
        total += rec(i);
    out.println("winning paths " + winning);
    out.println("total paths " + total);
    out.flush();
    out.close();
  }
}
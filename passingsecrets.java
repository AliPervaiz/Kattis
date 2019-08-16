import java.util.*;
import java.io.*;
import java.math.*;

public class passingsecrets
{
  public static class Node
  {
      String s;
      int d;
      String path;
      public Node(String s, int d, String path)
      {
          this.s = s;
          this.d = d;
          this.path = path;
      }
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st;
    String line;
    while((line=input.readLine())!=null&&line.length()>0)
    {
        st = new StringTokenizer(line);
        String A = st.nextToken();
        String B = st.nextToken();
        int n = Integer.parseInt(input.readLine());
        HashMap<String,HashMap<String,Integer>> adj = new HashMap<String,HashMap<String,Integer>>();
        for(int i = 0; i < n; i++)
        {
            String[] ar = input.readLine().trim().split(" ");
            for(int r = 0; r < ar.length; r++)
            {
                if(!adj.containsKey(ar[r])) adj.put(ar[r],new HashMap<String,Integer>());
                for(int c = 0; c < ar.length; c++)
                    if(r!=c)
                        if(!adj.get(ar[r]).containsKey(ar[c])||ar.length-2<adj.get(ar[r]).get(ar[c]))
                            adj.get(ar[r]).put(ar[c],ar.length-2);
            }
        }
        HashMap<String,Integer> dp = new HashMap<String,Integer>();
        HashMap<String,String> paths = new HashMap<String,String>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(A,0,A));
        dp.put(A,0);
        while(!q.isEmpty())
        {
            Node nod = q.poll();
            if(nod.d>dp.get(nod.s)) continue;
            if(!adj.containsKey(nod.s)) continue;
            for(String j : adj.get(nod.s).keySet())
            {
                if(!dp.containsKey(j)||nod.d+adj.get(nod.s).get(j)+1<dp.get(j))
                {
                    dp.put(j,nod.d+adj.get(nod.s).get(j)+1);
                    paths.put(j,nod.path + " " + j);
                    q.add(new Node(j,nod.d+adj.get(nod.s).get(j)+1,nod.path + " " + j));
                }
            }
        }
        if(!dp.containsKey(B)) out.println("impossible");
        else out.println(dp.get(B)-1 + " " + paths.get(B));
    }
    out.flush();
    out.close();
  }
}
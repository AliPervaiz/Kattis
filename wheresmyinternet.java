import java.util.*;
import java.io.*;
public class wheresmyinternet {
  public static void main(String[] args)throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(
                                  new OutputStreamWriter(System.out, "UTF-8")));
    StringTokenizer st = new StringTokenizer(input.readLine());
    int nodes = Integer.parseInt(st.nextToken());
    int edges = Integer.parseInt(st.nextToken());
    HashMap<Integer,ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();
    for(int i = 0; i < edges; i++)
    {
      st = new StringTokenizer(input.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(!adj.containsKey(a))
      {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(b);
        adj.put(a,list);
      }
      else
        adj.get(a).add(b);
      if(!adj.containsKey(b))
      {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(a);
        adj.put(b,list);
      }
      else
        adj.get(b).add(a);
    }
    Queue<Integer> q = new LinkedList<Integer>();
    boolean[] bmap = new boolean[nodes+1];
    int total = 0;
    q.add(1);
    bmap[1] = true;
    if(!adj.containsKey(1)) for(int j = 2; j <= nodes; j++) out.println(j);
    else
    {
      while(!q.isEmpty())
      {
        int nod = q.poll();
        total++;
        for(int i : adj.get(nod))
        {
          if(!bmap[i])
          {
            q.add(i);
            bmap[i] = true;
          }
        }
      }
      if(total==nodes) out.println("Connected");
      else
      {
        int i = 0;
        while(total!=nodes)
        {
          i++;
          if(!bmap[i])
          {
            total++;
            out.println(i);
          }
        }
      } 
    }
    out.close();
  }  
}
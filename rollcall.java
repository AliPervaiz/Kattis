import java.util.*;
import java.io.*;
import java.math.*;

public class rollcall
{
  public static class Node implements Comparable<Node>
  {
    String f;
    String l;
    public Node(String f, String l)
    {
      this.f = f;
      this.l = l;
    }
    public int compareTo(Node other)
    {
      if(l.equals(other.l)) return f.compareTo(other.f);
      return l.compareTo(other.l);
    }
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line;
    StringTokenizer st;
    HashSet<String> duplicates = new HashSet<String>();
    HashSet<String> names = new HashSet<String>();
    PriorityQueue<Node> pq = new PriorityQueue<Node>();
    while((line=input.readLine())!=null&&line.length()>0)
    {
      st = new StringTokenizer(line);
      String f = st.nextToken();
      String l = st.nextToken();
      if(!names.add(f)) duplicates.add(f);
      pq.add(new Node(f,l));
    }
    while(!pq.isEmpty())
    {
      Node nod = pq.poll();
      if(duplicates.contains(nod.f))
        out.println(nod.f + " " + nod.l);
      else out.println(nod.f);  
    }
    out.flush();
    out.close();
  }
}
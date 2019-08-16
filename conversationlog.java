import java.util.*;
import java.io.*;

public class conversationlog
{
    public static class Node implements Comparable<Node>
    {
        String s;
        int c;
        public Node(String s, int c)
        {
            this.s = s;
            this.c = c;
        }
        public int compareTo(Node o)
        {
            if(c==o.c) return s.compareTo(o.s);
            else return -Integer.compare(c,o.c);
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int m = Integer.parseInt(input.readLine());
        HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
        HashMap<String,Integer> count = new HashMap<String,Integer>();
        HashMap<String,Integer> count2 = new HashMap<String,Integer>();
        while(m-->0)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String name = st.nextToken();
            if(!map.containsKey(name)) map.put(name, new HashSet<String>());
            while(st.hasMoreTokens())
            {
                String v = st.nextToken();
                if(!count2.containsKey(v)) count2.put(v,0);
                count2.put(v,1+count2.get(v));
                if(!count.containsKey(v)) count.put(v,0);
                if(map.get(name).add(v)) count.put(v,1+count.get(v));
            }
        }
        PriorityQueue<Node> ans = new PriorityQueue<Node>();
        for(String key : count.keySet()) if(count.get(key)==map.keySet().size()) ans.add(new Node(key,count2.get(key)));
        if(ans.size()==0) out.println("ALL CLEAR");
        else while(!ans.isEmpty()) out.println(ans.poll().s);
        out.flush();
        out.close();
    }
}
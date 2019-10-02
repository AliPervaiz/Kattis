import java.util.*;
import java.io.*;

public class monitoringskipaths
{
    public static class Node
    {
        int i;
        Node parent;
        ArrayList<Node> children;
        public Node(int i)
        {
            this.i = i;
            children = new ArrayList<Node>();
        }
    }
    public static void f(Node n)
    {
        for(Node c : n.children) f(c);
        if(!routes.containsKey(n.i)) return;
        boolean unvisitedChild = false;
        for(int i : routes.get(n.i))
        {
            if(!visited[i])
            {
                unvisitedChild = true;
                break;
            }
        }
        if(!unvisitedChild) return;
        monitored++;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n.i);
        visited[n.i] = true;
        while(!q.isEmpty())
        {
            int nod = q.poll();
            for(Node child : nodes[nod].children)
            {
                if(!visited[child.i])
                {
                    visited[child.i] = true;
                    q.add(child.i);
                }
            }
        }
    }
    public static Node[] nodes;
    public static HashMap<Integer,ArrayList<Integer>> routes;
    public static boolean[] visited;
    public static int monitored = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        routes = new HashMap<Integer,ArrayList<Integer>>();
        nodes = new Node[n];
        for(int i = 0; i < n; i++)
        {
            adjList.add(new ArrayList<Integer>());
            nodes[i] = new Node(i);
        }
        for(int i = 0; i < k; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjList.get(a).add(b);
            nodes[b].parent = nodes[a];
            nodes[a].children.add(nodes[b]);
        }
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(!routes.containsKey(a)) routes.put(a,new ArrayList<Integer>());
            routes.get(a).add(b);
        }
        visited = new boolean[n];
        for(int i = 0; i < n; i++) if(nodes[i].parent==null) f(nodes[i]);
        out.println(monitored);
        out.flush();
        out.close();
    }
}
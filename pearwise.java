import java.util.*;
import java.io.*;

public class pearwise
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> ballots = new HashMap<String,Integer>();
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int v = Integer.parseInt(st.nextToken());
            ballots.put(st.nextToken(), v);
        }
        boolean[][] adj = new boolean[n][n];
        for(char a = 'A'; a < 'A'+n; a++)
        {
            for(char b = (char)(a+1); b < 'A'+n; b++)
            {
                int aScore = 0;
                int bScore = 0;
                for(String ballot : ballots.keySet())
                {
                    if(ballot.indexOf(a+"")<ballot.indexOf(b+"")) aScore += ballots.get(ballot);
                    else bScore += ballots.get(ballot);
                }
                if(aScore>bScore) adj[b-'A'][a-'A'] = true;
                else adj[a-'A'][b-'A'] = true;
            }
        }
        for(int i = 0; i < n; i++)
        {
            Queue<Integer> q = new LinkedList<Integer>();
            boolean[] visited = new boolean[n];
            visited[i] = true;
            q.add(i);
            int count = 1;
            while(!q.isEmpty())
            {
                int j = q.poll();
                for(int k = 0; k < n; k++)
                {
                    if(adj[k][j] && !visited[k])
                    {
                        visited[k] = true;
                        count++;
                        q.add(k);
                    }
                }
            }
            if(count==n) out.println(String.format("%s: can win",(char)('A'+i)));
            else out.println(String.format("%s: can't win",(char)('A'+i)));
        }
        out.flush();
        out.close();
    }
}
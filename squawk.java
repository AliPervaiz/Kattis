import java.util.*;
import java.io.*;
import java.math.*;

public class squawk
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        boolean[][] adj = new boolean[n][n];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        long[] ar = new long[n];
        ar[s]++;
        for(int i = 0; i < t; i++)
        {
            long[] temp = new long[n];
            for(int j = 0; j < n; j++) if(ar[j]!=0) for(int k = 0; k < n; k++) if(adj[j][k]) temp[k] += ar[j];
            ar = temp;
        }
        long sum = 0;
        for(long i : ar) sum += i;
        out.println(sum);
        out.flush();
        out.close();
    }
}
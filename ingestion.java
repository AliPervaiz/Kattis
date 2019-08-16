import java.util.*;
import java.io.*;
import java.math.*;

public class ingestion
{
    public static int[] cals;
    public static int[][] dp;
    public static ArrayList<Integer> list;
    public static int rec(int ni, int mi)
    {
        if(ni>=dp.length) return 0;
        if(dp[ni][mi]!=-1) return dp[ni][mi];
        return dp[ni][mi] = Math.max(Math.max(rec(ni+1,mi+1)+Math.min(cals[ni],list.get(mi)),rec(ni+1,Math.max(mi-1,0))),rec(ni+2,0));
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cals = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) cals[i] = Integer.parseInt(st.nextToken());
        list = new ArrayList<Integer>();
        while(list.size()!=n)
        {
            list.add(m);
            m = m*2/3;
        }
        dp = new int[n][n];
        for(int r = 0; r < n; r++) Arrays.fill(dp[r],-1);
        out.println(rec(0,0));
        out.flush();
        out.close();
    }
}
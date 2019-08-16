import java.util.*;
import java.io.*;
import java.math.*;

public class icpcteamselection
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(input.readLine());
        while(tc-->0)
        {
            int n = Integer.parseInt(input.readLine())*3;
            int[] ar = new int[n];
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int i = 0; i < n; i++) ar[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(ar);
            int S = 0;
            int in = n-2;
            for(int i = 0; i < n/3; i++)
            {
                S += ar[in];
                in-=2;
            }
            out.println(S);
        }
        out.flush();
        out.close();
    }
}
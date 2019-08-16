import java.util.*;
import java.io.*;
public class cd
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0&&m==0) break;
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = Integer.parseInt(input.readLine());
            int count = 0;
            int in = 0;
            for(int i = 0; i < m; i++)
            {
                int v = Integer.parseInt(input.readLine());
                while(in<n&&a[in]<v) in++;
                if(in==n) continue;
                if(a[in]==v) count++;
            }
            out.println(count);
        }
        out.flush();
        out.close();
    }
}
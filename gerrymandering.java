import java.util.*;
import java.io.*;

public class gerrymandering
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int p = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] a = new int[d+1];
        int[] b = new int[d+1];
        int wa = 0;
        int wb = 0;
        int v = 0;
        for(int i = 0; i < p; i++)
        {
            st = new StringTokenizer(input.readLine());
            int di = Integer.parseInt(st.nextToken());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            v += ai+bi;
            a[di] += ai;
            b[di] += bi;
        }
        for(int i = 1; i <= d; i++)
        {
            int total = a[i] + b[i];
            if(a[i]>b[i])
            {
                out.print("A ");
                wb += b[i];
                int majority = (int)Math.floor(total/2.0) + 1;
                wa += a[i]-majority;
                out.println((a[i]-majority) + " " + b[i]);
            }
            else
            {
                out.print("B ");
                wa += a[i];
                int majority = (int)Math.floor(total/2.0) + 1;
                wb += b[i]-majority;
                out.println(a[i] + " " + (b[i]-majority));
            }
        }
        double e = 1.0*Math.abs(wa-wb)/v;
        out.println(e);
        out.flush();
        out.close();
    }
}
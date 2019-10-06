import java.util.*;
import java.io.*;

public class stopcounting
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        long sum = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) sum += a[i] = Integer.parseInt(st.nextToken());
        double bestAVG = Math.max(0,1.0*sum/n);
        long lSum = sum;
        long rSum = sum;
        for(int i = 0; i < n-1; i++)
        {
            lSum -= a[i];
            rSum -= a[n-i-1];
            bestAVG = Math.max(bestAVG,Math.max(1.0*lSum/(n-i-1),1.0*rSum/(n-i-1)));
        }
        out.println(bestAVG);
        out.flush();
        out.close();
    }
}
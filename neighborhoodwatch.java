import java.util.*;
import java.io.*;
import java.math.*;

public class neighborhoodwatch 
{
    public static void main(String args[])throws IOException 
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        long n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] ar = new long[k];
        for(int i = 0; i < k; i++) ar[i] = Integer.parseInt(input.readLine());
        long bad = 0;
        if(ar.length>0) bad += ar[0]*(ar[0]-1)/2;
        for(int i = 1; i < k; i++)
        {
            long diff = ar[i]-ar[i-1];
            bad += diff*(diff-1)/2;
        }
        if(ar.length>0) bad += (n-ar[k-1])*(n-ar[k-1]+1)/2;
        if(k==0) bad = n*(n+1)/2;
        out.println(n*(n+1)/2-bad);
        out.flush();
        out.close();
    }
}

import java.util.*;
import java.io.*;

public class missingnumbers
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = Integer.parseInt(input.readLine());
        int max = a[n-1];
        boolean[] b = new boolean[max+1];
        for(int i = 0; i < n; i++) b[a[i]] = true;
        if(n==max) out.println("good job");
        for(int i = 1; i <= max; i++) if(!b[i]) out.println(i);
        out.flush();
        out.close();
    }
}
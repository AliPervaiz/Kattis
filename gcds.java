import java.util.*;
import java.io.*;
import java.math.*;

public class gcds
{
    public static int f(int a, int b)
    {
        if(a==-1) return b;
        if(b==0) return a;
        return f(b,a%b);
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        int[] ar = new int[n];
        for(int i = 0; i < n; i++) ar[i] = Integer.parseInt(input.readLine());
        int co = 0;
        for(int i = 1; i <= 100; i++)
        {
            int gcd = -1;
            for(int j = 0; j < n; j++)
            {
                if(ar[j]%i==0) gcd = f(gcd,ar[j]);
                else gcd = -1;
                if(gcd==i)
                {
                    co++;
                    break;
                }
            }
        }
        out.println(co);
        out.flush();
        out.close();
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class diagonalcut
{
    public static long gcd(long a, long b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static long f(long a, long b)
    {
        long temp = Math.max(a,b);
        a = Math.min(a,b);
        b = temp;
        long diff = b-a;
        if(diff%2!=0) return 0;
        return 1;
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long gcd = gcd(a,b);
        out.println(gcd*f(a/gcd,b/gcd));
        out.flush();
        out.close();
    }
}
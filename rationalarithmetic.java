import java.util.*;
import java.io.*;
public class rationalarithmetic
{
    public static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
    public static long lcm(long a, long b)
    {
        return a*b/gcd(a,b);
    }
    public static void add(long n1, long d1, long n2, long d2)
    {
        long D = lcm(d1,d2);
        long N = n1*(D/d1) + n2*(D/d2);
        long gcd = gcd(Math.abs(N),Math.abs(D));
        if(N<=0&&D<=0) gcd *= -1;
        N /= gcd;
        D /= gcd;
        if(D<0&&N>=0)
        {
            D *= -1;
            N *= -1;
        }
        System.out.println(N + " / " + D);
    }
    public static void mult(long n1, long d1, long n2, long d2)
    {
        long N = n1*n2;
        long D = d1*d2;
        long gcd = gcd(Math.abs(N),Math.abs(D));
        if(N<=0&&D<=0) gcd *= -1;
        N /= gcd;
        D /= gcd;
        if(D<0&&N>=0)
        {
            D *= -1;
            N *= -1;
        }
        System.out.println(N + " / " + D);
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int TC = Integer.parseInt(st.nextToken());
        while(TC-->0)
        {
            st = new StringTokenizer(input.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            char o = st.nextToken().charAt(0);
            int n2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            if(o=='+') add(n1,d1,n2,d2);
            if(o=='-') add(n1,d1,-n2,d2);
            if(o=='*') mult(n1,d1,n2,d2);
            if(o=='/') mult(n1,d1,d2,n2);
        }
    }
}
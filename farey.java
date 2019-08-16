import java.util.*;
import java.io.*;

public class farey
{
    public static int totient(int n)
    {
        double ans = n;
        for (int d = 2; d <= Math.sqrt(n); d++)
        {
            if (n % d == 0)
            {
                while (n % d == 0)
                    n /= d;
                ans *= 1 - 1.0/d;
            }
        }
        if (n > 1) ans *= 1 - 1.0/n;
        return (int)Math.round(ans);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] ar = new int[10001];
        ar[1] = 2;
        for(int i = 2; i < ar.length; i++) ar[i] = ar[i-1] + totient(i);
        int tc = input.nextInt();
        while(tc-->0)
        {
            int t = input.nextInt();
            int n = input.nextInt();
            System.out.println(t + " " + ar[n]);
        }
    }
}
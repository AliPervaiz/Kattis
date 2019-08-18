import java.util.*;
import java.io.*;

public class nonprimefactors
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int[] pf = new int[2000001];
        int[] divisors = new int[2000001];
        Arrays.fill(divisors,1);
        for(int r = 2; r < pf.length; r++)  
        {
            if(pf[r]==0)
            {
                pf[r]++;
                divisors[r]++;
                for(int c = r*2; c < pf.length; c+=r)
                {
                    pf[c]++;
                    int times = 1;
                    int temp = c;
                    while(temp%r==0)
                    {
                        temp/=r;
                        times++;
                    }
                    divisors[c] *= times;
                }
            }
        }
        int q = Integer.parseInt(input.readLine());
        while(q-->0)
        {
            int n = Integer.parseInt(input.readLine());
            out.println(divisors[n] - pf[n]);
        }
        out.flush();
        out.close();
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class generalizedrecursivefunctions
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(input.readLine());
        while(tc-->0)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int l = st.countTokens();
            int[] A = new int[(l-2)/2];
            int[] B = new int[(l-2)/2];
            for(int i = 0; i < A.length; i++)
            {
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }
            BigInteger C = new BigInteger(st.nextToken());
            BigInteger D = new BigInteger(st.nextToken());
            BigInteger[][] dp = new BigInteger[100][100];
            for(int x = 0; x < 100; x++)
            {
                for(int y = 0; y < 100; y++)
                {
                    if(x==0||y==0)
                    {
                        dp[x][y] = D;
                        continue;
                    }
                    BigInteger sum = BigInteger.ZERO;
                    for(int i = 0; i < A.length; i++)
                    {
                        int x2 = x-A[i];
                        int y2 = y-B[i];
                        if(x2<=0||y2<=0) sum = sum.add(D);
                        else sum = sum.add(dp[x2][y2]);
                    }
                    dp[x][y] = sum.add(C);
                }
            }
            st = new StringTokenizer(input.readLine());
            l = st.countTokens();
            for(int i = 0; i < l/2; i++)
            {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                out.println(dp[x][y]);
            }
            out.println();
        }
        out.flush();
        out.close();
    }
}
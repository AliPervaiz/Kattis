import java.util.*;
import java.io.*;
import java.math.*;

public class increasingsubsequence
{
    public static boolean isLess(String[] a, String[] b)
    {
        for(int i = 0; i < a.length; i++)
        {
            int A = Integer.parseInt(a[i]);
            int B = Integer.parseInt(b[i]);
            if(A<B) return true;
            if(B>A) return false;
        }
        return false;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) ar[i] = Integer.parseInt(st.nextToken());
            int[] dp = new int[n];
            String[] path = new String[n];
            Arrays.fill(dp,1);
            int best = 0;
            String ans = Integer.MAX_VALUE + "";
            for(int r = 0; r < n; r++)
            {
                if(path[r]==null) path[r] = ar[r]+"";
                if(best<=1&&ar[r]<Integer.parseInt(ans))
                {
                    best = 1;
                    ans = ar[r]+"";
                }
                for(int c = r+1; c < n; c++)
                {
                    if(ar[c]>ar[r]&&dp[r]+1>dp[c])
                    {
                        dp[c] = dp[r] + 1;
                        path[c] = path[r] + " " + ar[c];
                        if(dp[c] > best)
                        {
                            best = dp[c];
                            ans = path[c];
                        }
                    }
                    if(ar[c]>ar[r]&&dp[r]+1==dp[c])
                    {
                        String[] ar1 = path[c].split(" ");
                        String[] ar2 = (path[r] + " " + ar[c]).split(" ");
                        if(isLess(ar2,ar1)) path[c] = path[r] + " " + ar[c];
                        if(dp[c] == best)
                            ans = path[c];
                    }
                }
            }
            out.println(best + " " + ans);
        }
        out.flush();
        out.close();
    }
}
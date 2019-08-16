import java.util.*;
import java.io.*;
import java.math.*;

public class mastermind
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        String a = st.nextToken();
        String b = st.nextToken();
        int[] ar1 = new int[26];
        int[] ar2 = new int[26];
        int r = 0;
        int s = 0;
        for(int c = 0; c < n; c++)
        {
            if(a.charAt(c)==b.charAt(c)) r++;
            else
            {
                ar1[a.charAt(c)-'A']++;
                ar2[b.charAt(c)-'A']++;
            }
        }
        for(int i = 0; i < 26; i++) s += Math.min(ar1[i],ar2[i]);
        out.println(r + " " + s);
        out.flush();
        out.close();
    }
}
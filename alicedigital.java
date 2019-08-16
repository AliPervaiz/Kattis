import java.util.*;
import java.io.*;
import java.math.*;

public class alicedigital
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(input.readLine());
        while(tc-->0)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int before = 0;
            int after = 0;
            boolean seenM = false;
            int best = 0;
            st = new StringTokenizer(input.readLine());
            for(int i = 0; i < n; i++)
            {
                int v = Integer.parseInt(st.nextToken());
                if(v<m)
                {
                    if(seenM)
                    {
                        if(before+m+after>best) best = before+m+after;
                        seenM = false;
                    }
                    before = 0;
                    after = 0;
                }
                else if(v==m)
                {
                    if(seenM)
                    {
                        if(before+m+after>best) best = before+m+after;
                        before = after;
                        after = 0;
                    }
                    else seenM = true;
                }
                else if(!seenM) before += v;
                else after += v;
            }
            if(seenM&&before+m+after>best) best = before+m+after;
            out.println(best);
        }
        out.flush();
        out.close();
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class tightlypacked {
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        long n = Long.parseLong(input.readLine());
        long best = Long.MAX_VALUE;
        long w = (long)Math.ceil(Math.sqrt(n));
        while(true)
        {
            long h = n/w+1;
            if(n%w==0) h--;
            if(h*2<w) break;
            if((w*h)-n < best) best = w*h-n;
            w++;
        }
        out.println(best);
        out.flush();
        out.close();
    }
}
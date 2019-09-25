import java.util.*;
import java.io.*;

public class difference
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int r = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = 1;
        boolean[] a = new boolean[m+1];
        ArrayList<Integer> differences = new ArrayList<Integer>();
        if(r<a.length) a[r] = true;
        int d = 1;
        while(!a[m])
        {
            n++;
            while(a[d]) d++;
            for(int i = 0; i < differences.size(); i++)
            {
                differences.set(i,differences.get(i)+d);
                if (differences.get(i)<a.length) a[differences.get(i)] = true;
            }
            differences.add(d);
            if(d<a.length) a[d] = true;
            r += d;
            if(r<a.length) a[r] = true;
        }
        out.println(n);
        out.flush();
        out.close();
    }
}
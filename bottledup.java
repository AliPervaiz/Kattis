import java.util.*;
import java.io.*;
import java.math.*;

public class bottledup
{
    public static class Node
    {
        int r;
        int c;
        int d;
        public Node(int r, int c, int d)
        {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int s = Integer.parseInt(st.nextToken());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int bestA = -1;
        int bestB = -1;
        for(int a = 0; a <= 1000000; a++)
        {
            if(a*v1>s) break;
            int left = s-a*v1;
            if(left%v2!=0) continue;
            int b = left/v2;
            bestA = a;
            bestB = b;
        }
        if(bestA==-1) out.println("Impossible");
        else out.println(bestA  + " " + bestB);
        out.flush();
        out.close();
    }
}
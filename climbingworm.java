import java.util.*;
import java.io.*;
import java.math.*;

public class climbingworm
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int i = 0;
        int times = 0;
        while(true)
        {
            times++;
            i+=a;
            if(i>=h)break;
            i-=b;
        }
        out.println(times);
        out.flush();
        out.close();
    }
}
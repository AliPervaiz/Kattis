import java.util.*;
import java.io.*;

public class zipline
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        while(n-->0)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            double w = Double.parseDouble(st.nextToken());
            double g = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());
            double r = Double.parseDouble(st.nextToken());
            double minDist = Math.sqrt(w*w + (g-h)*(g-h));
            double d = (g-r)/(h-r);
            double maxX =  d*w/(1+d);
            double maxDist = Math.sqrt(Math.pow(maxX,2)+Math.pow(g-r,2)) + Math.sqrt(Math.pow(w-maxX,2)+Math.pow(h-r,2));
            if(h==r) maxDist = minDist;
            out.println(minDist + " " + maxDist);
        }
        out.flush();
        out.close();
    }
}
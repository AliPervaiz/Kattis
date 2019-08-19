import java.util.*;
import java.io.*;

public class areyoulistening
{
    public static double dist(int a, int b, int c, int d)
    {
        return Math.sqrt(Math.pow(a-c, 2) + Math.pow(b-d, 2));
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Double> dists = new ArrayList<Double>();
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            dists.add(Math.max(0,dist(cx,cy,x,y)-r));
        }
        Collections.sort(dists);
        out.println(Math.max(0,(int)Math.floor(dists.get(2))));
        out.flush();
        out.close();
    }
}
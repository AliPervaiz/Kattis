import java.util.*;
import java.io.*;

public class purplerain
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String l = input.readLine();
        int best = 0;
        int s = 0;
        int e = 0;
        int rCount = 0;
        int bCount = 0;
        int rS = 0;
        int bS = 0;
        for(int c = 0; c < l.length(); c++)
        {
            if(l.charAt(c)=='B')
            {
                bCount++;
                rCount--;
            }
            else
            {
                bCount--;
                rCount++;
            }
            if(bCount<0)
            {
                bCount = 0;
                bS = c+1;
            }
            if(rCount<0)
            {
                rCount = 0;
                rS = c+1;
            }
            if(bCount>best)
            {
                best = bCount;
                s = bS;
                e = c;
            }
            if(rCount>best)
            {
                best = rCount;
                s = rS;
                e = c;
            }
        }
        out.println(s+1 + " " + (e+1));
        out.flush();
        out.close();
    }
}
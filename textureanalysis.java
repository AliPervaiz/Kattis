import java.util.*;
import java.io.*;

public class textureanalysis
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = 0;
        while(true)
        {
            tc++;
            String line = input.readLine();
            if(line.equals("END")) break;
            int black = 0;
            int c = 0;
            HashSet<Integer> sizes = new HashSet<Integer>();
            for(int i = 0; i < line.length(); i++)
            {
                if(line.charAt(i)=='.') c++;
                else 
                {
                    if(black>0) sizes.add(c);
                    black++;
                    c = 0;
                }
            }
            if(sizes.size()<=1) out.println(tc + " EVEN");
            else out.println(tc + " NOT EVEN");
        }
        out.flush();
        out.close();
    }
}
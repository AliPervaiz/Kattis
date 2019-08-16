import java.util.*;
import java.io.*;
public class golombrulers
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String line = input.readLine();
        while(line!=null&&line.length()>0)
        {
            String[] ar = line.split(" ");
            int max = 0;
            for(int r = 0; r < ar.length; r++)
            {
                int a = Integer.parseInt(ar[r]);
                if(a>max) max = a;
            }
            boolean[] bmap = new boolean[max+1];
            int count = 1;
            bmap[0] = true;
            boolean not = false;
            fam: for(int r = 0; r < ar.length; r++)
            {
                int a = Integer.parseInt(ar[r]);
                for(int c = r+1; c < ar.length; c++)
                {
                    int b = Integer.parseInt(ar[c]);
                    if(!bmap[Math.abs(a-b)])
                    {
                        count++;
                        bmap[Math.abs(a-b)] = true;
                    }
                    else
                    {
                        not = true;
                        break;
                    }
                }
            }
            if(not) writer.println("not a ruler");
            else if(count==bmap.length) writer.println("perfect");
            else
            {
                writer.print("missing");
                for(int i = 1; i < bmap.length; i++)
                    if(!bmap[i]) writer.print(" " + i);
                writer.println();   
            }
            line = input.readLine();
        }
        writer.flush();
        writer.close();
    }
}
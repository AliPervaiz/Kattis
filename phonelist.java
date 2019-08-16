import java.util.*;
import java.io.*;

public class phonelist
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(input.readLine());
        while(tc-->0)
        {
            int n = Integer.parseInt(input.readLine());
            String[] ar = new String[n];
            for(int i = 0; i < n; i++) ar[i] = input.readLine();
            Arrays.sort(ar);
            boolean works = true;
            for(int i = 1; i < n; i++) 
            {
                if(ar[i].indexOf(ar[i-1])==0)
                {
                    works = false;
                    break;
                }
            }
            if(works) out.println("YES");
            else out.println("NO");
        }
        out.flush();
        out.close();
    }
}
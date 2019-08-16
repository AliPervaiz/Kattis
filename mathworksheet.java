import java.util.*;
import java.io.*;
import java.math.*;

public class mathworksheet
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = 0;
        while(true)
        {
            T++;
            int n = Integer.parseInt(input.readLine());
            if(n == 0) break;
            if(T!=1) out.println();
            ArrayList<String> list = new ArrayList<String>();
            for(int i = 0; i < n; i++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                char t = st.nextToken().charAt(0);
                int b = Integer.parseInt(st.nextToken());
                if(t == '+') list.add(a+b+"");
                if(t == '-') list.add(a-b+"");
                if(t == '*') list.add(a*b+"");
            }
            int len = 0;
            for(String s : list) len = Math.max(len,s.length());
            int cSize = 50/len;
            String line = String.format("%"+len+"s",list.get(0));
            for(int i = 1; i < list.size(); i++)
            {
                if((line + " " + String.format("%"+len+"s",list.get(i))).length()>50)
                {
                    out.println(line);
                    line = String.format("%"+len+"s",list.get(i));
                }
                else line += " " + String.format("%"+len+"s",list.get(i));
            }
            if(line.length()>0) out.println(line);
        }
        out.flush();
        out.close();
    }
}
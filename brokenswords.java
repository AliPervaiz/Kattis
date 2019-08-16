import java.util.*;
import java.io.*;
import java.math.*;

public class brokenswords
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        int tb = 0;
        int lr = 0;
        while(n-->0)
        {
            String s = input.readLine();
            if(s.charAt(0)=='0') tb++;
            if(s.charAt(1)=='0') tb++;
            if(s.charAt(2)=='0') lr++;
            if(s.charAt(3)=='0') lr++;
        }
        int min = Math.min(tb/2,lr/2);
        tb -= min*2;
        lr -= min*2;
        out.println(min + " " + tb + " " + lr);
        out.flush();
        out.close();
    }
}
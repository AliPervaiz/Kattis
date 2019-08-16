import java.util.*;
import java.io.*;
import java.math.*;

public class evenup
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        Stack<Integer> s = new Stack<Integer>();
        while(n-->0)
        {
            int i = Integer.parseInt(st.nextToken());
            if(s.size()==0) s.add(i);
            else if((s.peek()+i)%2==0) s.pop();
            else s.add(i);
        }
        out.println(s.size());
        out.flush();
        out.close();
    }
}
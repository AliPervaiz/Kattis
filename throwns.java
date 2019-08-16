import java.util.*;
import java.io.*;
import java.math.*;

public class throwns
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);
        for(int i = 0; i < k; i++)
        {
            String command = st.nextToken();
            if(command.equals("undo"))
            {
                int x = Integer.parseInt(st.nextToken());
                for(int j = 0; j < x; j++) stack.pop();
            }
            else stack.add(stack.peek() + Integer.parseInt(command));
        }
        int x = stack.peek();
        while(x<0) x += n;
        x %= n;
        out.println(x);
        out.flush();
        out.close();
    }
}
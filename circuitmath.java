import java.util.*;
import java.io.*;

public class circuitmath
{
    public static char eval(String s)
    {
        s = s.replace(" ","");
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)=='*')
            {
                char one = stack.pop();
                char two = stack.pop();
                if(one=='T'&&two=='T') stack.add('T');
                else stack.add('F');
            }
            else if(s.charAt(i)=='+')
            {
                char one = stack.pop();
                char two = stack.pop();
                if(one=='T'||two=='T') stack.add('T');
                else stack.add('F');
            }
            else if(s.charAt(i)=='-')
            {
                char one = stack.pop();
                if(one=='T') stack.add('F');
                else stack.add('T');
            }
            else stack.add(s.charAt(i));
        }
        return stack.peek();
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(input.readLine());
        char[] a = new char[n];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++) a[i] = st.nextToken().charAt(0);
        String s = input.readLine();
        String temp = "";
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z') temp += a[s.charAt(i)-'A'];
            else temp += s.charAt(i);
        }
        out.println(eval(temp));
        out.flush();
        out.close();
    }
}
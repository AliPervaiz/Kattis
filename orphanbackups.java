import java.util.*;
import java.io.*;

public class orphanbackups
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashSet<String> one = new HashSet<String>();
        HashSet<String> two = new HashSet<String>();
        PriorityQueue<String> F = new PriorityQueue<String>();
        PriorityQueue<String> I = new PriorityQueue<String>();
        String line;
        while((line=input.readLine())!=null&&line.length()>0) one.add(line);
        while((line=input.readLine())!=null&&line.length()>0)
        {
            int under = 0;
            String name = "";
            for(int i = line.length()-1; i >= 0; i--)
            {
                if(line.charAt(i)=='_') under++;
                if(under == 2)
                {
                    name = line.substring(0,i);
                    break;
                }
            }
            if(!one.contains(name))  F.add(line);
            else two.add(name);
        }
        for(String s : one) if(!two.contains(s)) I.add(s);
        if(F.isEmpty()&&I.isEmpty()) out.println("No mismatches.");
        while(!F.isEmpty()) out.println("F " + F.poll());
        while(!I.isEmpty()) out.println("I " + I.poll());
        out.flush();
        out.close();
    }
}
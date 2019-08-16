import java.util.*;
import java.io.*;
import java.math.*;

public class goodmessages
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int o = Integer.parseInt(input.readLine());
        String s = input.readLine();
        int n = Integer.parseInt(input.readLine());
        int good = 0;
        int bad = 0;
        String vowels = "aeiouy";
        for(int i = 0; i < n; i++)
        {
            String temp = "";
            int vows = 0;
            int cons = 0;
            for(int c = 0; c < s.length(); c++)
            {
                temp += (char)('a'+((s.charAt(c)-'a'+o)%26));
                if(vowels.contains(""+temp.charAt(temp.length()-1))) vows++;
                else cons++;
            }
            s = temp;
            if(vows*2>=cons) bad++;
            else good++;
        }
        if(good>bad) out.println("Boris");
        else out.println("Colleague");
        out.flush();
        out.close();
    }
}
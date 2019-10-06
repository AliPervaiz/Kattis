import java.util.*;
import java.io.*;

public class summertrip
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String s = input.readLine();
        int count = 0;
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen,-1);
        lastSeen[s.charAt(0)-'a'] = 0;
        for(int i = 1; i < s.length(); i++)
        {
            for(int j = 'a'; j <= 'z'; j++) if(lastSeen[j-'a']>lastSeen[s.charAt(i)-'a']) count++;
            lastSeen[s.charAt(i)-'a'] = i;
        }
        out.println(count);
        out.flush();
        out.close();
    }
}
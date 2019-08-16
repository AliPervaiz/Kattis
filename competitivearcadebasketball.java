import java.util.*;
import java.io.*;
import java.math.*;

public class competitivearcadebasketball
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < n; i++) map.put(input.readLine(),0);
        HashSet<String> winners = new HashSet<String>();
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(input.readLine());
            String name = st.nextToken();
            map.put(name,map.get(name)+Integer.parseInt(st.nextToken()));
            if(map.get(name)>=p&&winners.add(name)) out.println(name + " wins!");
        }
        if(winners.size()==0) out.println("No winner!");
        out.flush();
        out.close();
    }
}
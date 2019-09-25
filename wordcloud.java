import java.util.*;
import java.io.*;

public class wordcloud
{
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = 0;
        while(true)
        {
            tc++;
            StringTokenizer st = new StringTokenizer(input.readLine());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(w==0&&n==0) break;
            TreeMap<String,Integer> map = new TreeMap<String,Integer>();
            int maxCount = 0;
            for(int i = 0; i < n; i++)
            {
                st = new StringTokenizer(input.readLine());
                String word = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                if(count>=5) map.put(word,count);
                if(count>maxCount) maxCount = count;
            }
            int currWidth = 0;
            int currMaxHeight = 0;
            int totalHeight = 0;
            for(String key : map.keySet())
            {
                int tempWidth = currWidth;
                if(tempWidth!=0) tempWidth += 10;
                int P = 8 + (int)Math.ceil((40.0*(map.get(key)-4))/(maxCount-4));
                int width = (int)Math.ceil(9/16.0*key.length()*P);
                tempWidth += width;
                if(tempWidth>w)
                {
                    totalHeight += currMaxHeight;
                    currWidth = width;
                    currMaxHeight = P;
                }
                else
                {
                    currWidth = tempWidth;
                    currMaxHeight = Math.max(currMaxHeight,P);
                }
            }
            out.printf("CLOUD %d: %d%n",tc,totalHeight + currMaxHeight);
        }
        out.flush();
        out.close();
    }
}
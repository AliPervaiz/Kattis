import java.util.*;
import java.io.*;

public class lexicography
{
    public static long f(int[] count, int in)
    {
        int n = -1;
        for(int i : count) n += i;
        long fact = 1;
        for(int i = 2; i <= n; i++) fact *= i;
        for(int i = 0; i < count.length; i++)
        {
            if(i==in) fact *= count[i];
            for(int j = 2; j <= count[i]; j++) fact /= j;
        }
        return fact;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String s = st.nextToken();
            long k = Long.parseLong(st.nextToken());
            if(s.equals("#")) break;
            int n = s.length();
            int[] count = new int[26];
            for(int i = 0; i < n; i++) count[s.charAt(i)-'A']++;
            String ans = "";
            long cSum = 0;
            while(n-->0)
            {
                //System.out.println(n + " " + cSum);
                for(int i = 0; i < 26; i++)
                {
                    long freqCount = f(count,i);
                    cSum += freqCount;
                    //if(freqCount!=0) System.out.println((char)(i+'A') + " " + freqCount);
                    
                    /*if(i==2) 
                    {
                        System.out.println(Arrays.toString(count));
                        System.out.println("C " + freqCount);
                    }*/
                    
                    if(cSum>=k)
                    {
                        ans += (char)('A' + i);
                        cSum -= freqCount;
                        count[i]--;
                        break;
                    }
                }
                //System.out.println(ans);
            }
            out.println(ans);
        }
        out.flush();
        out.close();
    }
}
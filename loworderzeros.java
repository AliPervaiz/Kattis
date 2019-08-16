import java.util.*;
import java.io.*;
import java.math.*;

public class loworderzeros
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int[] ans = new int[1000001];
        int mod = 1;
        int two = 0;
        int five = 0;
        ans[0] = 1;
        ans[1] = 1;
        for(int i = 2; i < ans.length; i++)
        {
            int n = i;
            while(n%2==0)
            {
                two++;
                n/=2;
            }
            while(n%5==0)
            {
                five++;
                n/=5;
            }
            mod = (mod*n)%10;
            int min = Math.min(two,five);
            int low = mod;
            two -= min;
            five -= min;
            two = two%4+4;
            for(int j = 0; j < two; j++) low = (low*2)%10;
            ans[i] = low;
        }
        while(true)
        {
            int q = Integer.parseInt(input.readLine());
            if(q==0) break;
            out.println(ans[q]);
        }
        out.flush();
        out.close();
    }
}
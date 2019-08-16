import java.util.*;
import java.io.*;
import java.math.*;

public class estate
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            int n = Integer.parseInt(input.readLine());
            if(n==0) break;
            int odd = 1;
            for(int i = 2; i <= Math.sqrt(n); i++)
            {
                if(n%i==0)
                {
                    if(i%2==1) odd++;
                    if(i*i!=n&&n/i%2==1) odd++;
                }
            }
            if(n%2!=0) odd++;
            int ti = (int)Math.sqrt(2*n);
            if(ti*(ti+1)/2==n) odd--;
            if(n==1) odd--;
            out.println(odd);
        }
        out.flush();
        out.close();
    }
}
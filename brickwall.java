import java.util.*;
import java.io.*;

public class brickwall
{
    public static int[][][] memo;
    public static boolean f(int a, int b, int c)
    {
        if(a<0||b<0||c<0) return false;
        if(a==0&&b==0&&c==0)
        {
            memo[a][b][c] = 1;
            return true;
        }
        if(memo[a][b][c]!=0) return memo[a][b][c] == 1;
        int size = a+2*b+3*c;
        if(badLengths.contains(size))
        {
            memo[a][b][c] = -1;
            return false;
        }
        boolean works = false;
        works = f(a-1,b,c)||f(a,b-1,c)||f(a,b,c-1);
        if(works) memo[a][b][c] = 1;
        else memo[a][b][c] = -1;
        return works;
    }
    public static int c1;
    public static int c2;
    public static int c3;
    public static HashSet<Integer> badLengths;
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        memo = new int[301][301][301];
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        c3 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        badLengths = new HashSet<Integer>();
        int sum = 0;
        for(int i = 0; i < N; i++)
        {
            int b = Integer.parseInt(st.nextToken());
            sum += b;
            if(i!=N-1) badLengths.add(sum);
        }
        boolean works = false;
        out: for(int a = 0; a <= c1; a++)
        {
            for(int b = 0; b <= c2; b++)
            {
                for(int c = 0; c <= c3; c++)
                {
                    if(a+2*b+3*c==sum&&f(a,b,c))
                    {
                        works = true;
                        break out;
                    }
                }
            }
        }
        if(works) out.println("YES");
        else out.println("NO");
        out.flush();
        out.close();
    }
}
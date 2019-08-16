import java.util.*;
import java.io.*;

public class aprizenoonecanwin
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long x = input.nextInt();
        long[] ar = new long[n];
        for(int i = 0; i < n; i++) ar[i] = input.nextInt();
        Arrays.sort(ar);
        int i = 0;
        while(i+1<ar.length&&ar[i+1]+ar[i]<=x) i++;
        i++;
        if(n==1) i=1;
        if(n>1&&ar[0]+ar[1]>x) i = 1;
        System.out.println(i);
    }
}
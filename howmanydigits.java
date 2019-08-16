import java.util.*;
import java.io.*;

public class howmanydigits
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt())
        {
            int n = input.nextInt();
            if(n==0||n==1) System.out.println(1);
            else
            {
                double x = (n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) /  2.0);
                System.out.println((long)Math.floor(x) + 1);
            }
        }
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class catalansquare
{
    public static BigInteger c(int n)
    {
        BigInteger num = BigInteger.ONE;
        for(int i = 2*n; i > n; i--) num = num.multiply(new BigInteger(i+""));
        for(int i = n; i >= 2; i--) num = num.divide(new BigInteger(i+""));
        return num.divide(new BigInteger(n+1+""));
    }
    public static void main(String[] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt()+1;
        System.out.println(c(n));
    }
}
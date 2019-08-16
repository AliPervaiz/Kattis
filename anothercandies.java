import java.util.*;
import java.io.*;
import java.math.*;

public class anothercandies
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        while(tc-->0)
        {
          int n = input.nextInt();
          BigInteger sum = BigInteger.ZERO;
          for(int i = 0; i < n; i++) sum = sum.add(new BigInteger(input.next()));
          if(sum.mod(new BigInteger(n+"")).equals(BigInteger.ZERO)) System.out.println("YES");
          else System.out.println("NO");
        }
    }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class sequence
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    System.out.println((int)Math.ceil(Math.log(n)/Math.log(2)+.0000001));
    for(long i = 1; i <= n; i*=2)
      System.out.print(i + " ");
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class meowfactor
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    long l = input.nextLong();
    long i = 127;
    while(l%(i*i*i*i*i*i*i*i*i)!=0) i--;
    System.out.println(i);
  }
}
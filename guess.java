import java.util.*;
import java.io.*;
import java.math.*;

public class guess
{
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      int l = 1;
      int r = 1000;
      while(true)
      {
        int m = (l+r)/2;
        System.out.println(m);
        String line = input.next();
        if(line.equals("correct")) break;
        else if(line.equals("lower"))
          r = m-1;
        else
          l = m+1;  
      }  
    }
}
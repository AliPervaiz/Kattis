import java.util.*;
import java.io.*;
import java.math.*;

public class almostperfect
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt())
    {
      HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
      BigInteger div = new BigInteger("2");
      int n = input.nextInt();
      int temp = n;
      while(temp!=1)
      {
        BigInteger bi = new BigInteger(temp+"");
        if(bi.isProbablePrime(95))
        {
          if(!map.containsKey(temp))
            map.put(temp,0);
          map.put(temp,1+map.get(temp));
          break;
        }
        int d = Integer.parseInt(div.toString());
        if(temp%d==0)
        {
          if(!map.containsKey(d)) map.put(d,0);
          map.put(d,1+map.get(d));
          temp/=d;
        }
        else
          div = div.nextProbablePrime();
      }
      int prod = 1;
      for(int key : map.keySet())
      {
        int sum = 1;
        for(int i = 1; i <= map.get(key); i++)
          sum += Math.pow(key,i);
        prod*=sum;  
      }
      prod -= n;
      if(prod==n)
        System.out.println(n + " perfect");
      else if(Math.abs(prod-n)<=2) 
        System.out.println(n + " almost perfect");
      else
        System.out.println(n + " not perfect");    
    }
  }
}
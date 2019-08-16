import java.util.*;
import java.io.*;
import java.math.*;

public class anagramcounting
{
  public static int[][] dmap;
  public static ArrayList<Integer> coins;
  public static int rec(int i, int n)
  {
    if(i==coins.size()) return 0;
    if(n<0) return 0;
    if(n==0) return 1;
    if(dmap[i][n]!=-1) return dmap[i][n];
    return dmap[i][n] = rec(i,n-coins.get(i))+rec(i+1,n);
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    BigInteger[] ar = new BigInteger[101];
    ar[0] = BigInteger.ONE;
    ar[1] = BigInteger.ONE;
    for(int i = 2; i < ar.length; i++)
      ar[i] = ar[i-1].multiply(new BigInteger(i+""));
    while(input.hasNext())
    {
      String s = input.next();
      HashMap<Character,Integer> map = new HashMap<Character,Integer>();
      for(int c = 0; c < s.length(); c++)
      {
        if(!map.containsKey(s.charAt(c)))
          map.put(s.charAt(c),0);
        map.put(s.charAt(c),1+map.get(s.charAt(c)));  
      }
      BigInteger ans = ar[s.length()];
      for(char key : map.keySet())
        ans = ans.divide(ar[map.get(key)]);
      System.out.println(ans);  
    }
  }
}

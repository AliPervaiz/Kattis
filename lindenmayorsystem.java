import java.util.*;
import java.io.*;
import java.math.*;

public class lindenmayorsystem
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    HashMap<Character,String> map = new HashMap<Character,String>();
    for(int i = 0; i < n; i++)
    {
      char key = input.next().charAt(0);
      input.next();
      map.put(key,input.next());
    }
    String s = input.next();
    for(int i = 0; i < m; i++)
    {
      String temp = "";
      for(int c = 0; c < s.length(); c++)
      {
        String rep = map.get(s.charAt(c));
        if(rep==null) rep = s.charAt(c)+"";
        temp += rep;
      }
      s = temp;  
    }
    System.out.println(s);
  }
}
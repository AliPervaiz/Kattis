import java.util.*;
import java.io.*;
import java.math.*;

public class palindromesubstring
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String s;
    while((s=input.readLine())!=null&&s.length()>0)
    {
      TreeSet<String> set = new TreeSet<String>();
      HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
      for(int c = 0; c < s.length(); c++)
      {
        if(!map.containsKey(s.charAt(c))) map.put(s.charAt(c),new ArrayList<Integer>());
        map.get(s.charAt(c)).add(c);
      }
      for(char ch : map.keySet())
      {
        ArrayList<Integer> list = map.get(ch);
        if(list.size()<2) continue;
        for(int r = 0; r < list.size(); r++)
        {
          for(int c = r+1; c < list.size(); c++)
          {
            StringBuilder sb = new StringBuilder(s.substring(list.get(r),list.get(c)+1));
            if(sb.toString().equals(sb.reverse().toString())) set.add(sb.toString());
          }
        }
      }
      for(String st : set) out.println(st);
      out.println();
    }
    out.flush();
    out.close();
  }
}
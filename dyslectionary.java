import java.util.*;
import java.io.*;
import java.math.*;

public class dyslectionary
{
  public static class Word implements Comparable<Word>
  {
    String s;
    String b;
    public Word(String s)
    {
      this.s = s;
      StringBuilder sb = new StringBuilder(s);
      b = sb.reverse().toString();
    }
    public int compareTo(Word other)
    {
      if(other.b.indexOf(b)==0) return -1;
      else if(b.indexOf(other.b)==0) return 1;
      return b.compareTo(other.b);
    }
    public String toString()
    {
      return s;
    }
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    PriorityQueue<Word> pq = new PriorityQueue<Word>();
    int max = 0;
    while(input.hasNextLine())
    {
      String line = input.nextLine();
      if(line.equals(""))
      {
        while(!pq.isEmpty()) 
          System.out.printf("%"+max+"s%n",pq.poll());
        System.out.println();
        max = 0;
        pq = new PriorityQueue<Word>();
        continue;
      }
      max = Math.max(max,line.length());
      pq.add(new Word(line));
    }
    while(!pq.isEmpty()) 
          System.out.printf("%"+max+"s%n",pq.poll());
  }
}

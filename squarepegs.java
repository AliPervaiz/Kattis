import java.util.*;
import java.io.*;
import java.math.*;

public class squarepegs
{
  public static class House implements Comparable<House>
  {
    int r;
    boolean circle;
    double max;
    public House(int r, boolean c)
    {
      this.r = r;
      circle = c;
      if(!circle) max = r*Math.sqrt(2)/2;
      else max = r;
    }
    public int compareTo(House other)
    {
      return -Double.compare(max,other.max);
    }
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int M = input.nextInt();
    int K = input.nextInt();
    int[] plots = new int[N];
    for(int i = 0; i < N; i++)
      plots[i] = input.nextInt();
    Arrays.sort(plots);  
    PriorityQueue<House> Houses = new PriorityQueue<House>();
    for(int i = 0; i < M; i++)
      Houses.add(new House(input.nextInt(),true));
    for(int i = 0; i < K; i++)
      Houses.add(new House(input.nextInt(),false));
    int in = N-1; 
    while(!Houses.isEmpty())
    {
      if(in<0) break;
      House temp = Houses.poll();
      if(temp.circle)
      {
        if(temp.r<plots[in])
          in--;
      }
      else if(!temp.circle&&temp.r*Math.sqrt(2)/2<plots[in])
          in--;    
    }
    System.out.println(N-1-in);      
  }
}
import java.util.*;
import java.io.*;
import java.math.*;

public class simplepolygon
{
  public static class Point implements Comparable<Point>
  {
    double r;
    double a;
    int i;
    public Point(double a, double r, int i)
    {
      this.a = a;
      this.r = r;
      this.i = i;
    }
    public int compareTo(Point other)
    {
      if(a==other.a)
        return Double.compare(r,other.r);
      return Double.compare(a,other.a);   
    }
    public String toString()
    {
      return i+"";
    }
  }
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int tc = input.nextInt();
    while(tc-->0)
    {
      int n = input.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      double xavg = 0;
      double yavg = 0;
      for(int i = 0; i < n; i++)
      {
        x[i] = input.nextInt();
        y[i] = input.nextInt();
        xavg += x[i];
        yavg += y[i];
      }
      xavg /= n;
      yavg /= n;
      PriorityQueue<Point> pq = new PriorityQueue<Point>();
      for(int i = 0; i < n; i++)
        pq.add(new Point(Math.atan2(y[i]-yavg,x[i]-xavg),Math.sqrt(Math.pow(xavg-x[i],2)+Math.pow(yavg-y[i],2)),i));
      while(!pq.isEmpty())
        System.out.print(pq.poll() + " ");
      System.out.println();  
    }
  }
}
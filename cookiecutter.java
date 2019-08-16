import java.util.*;
import java.io.*;
import java.math.*;

public class cookiecutter
{
  public static void main(String[] args) throws IOException
  {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double[] x = new double[n];
    double[] y = new double[n];
    double minx = 0;
    double miny = 0;
    for(int i = 0; i < n; i++)
    {
      x[i] = input.nextDouble();
      y[i] = input.nextDouble();
      if(x[i]<minx) minx = x[i];
      if(y[i]<miny) miny = y[i];
    }
    for(int i = 0; i < n; i++)
    {
      x[i] -= minx;
      y[i] -= miny;
    }
    double left = x[n-1]*y[0];
    for(int i = 0; i < n-1; i++)
      left += x[i]*y[i+1];
    double right = x[0]*y[n-1];
    for(int i = 0; i < n-1; i++)
      right += x[i+1]*y[i];
    double area = Math.abs(left-right)/2;
    double A = input.nextDouble();
    double f = A/area;
    minx = Double.MAX_VALUE;
    miny = Double.MAX_VALUE;
    for(int i = 0; i < n; i++)
    {
      x[i] *= Math.sqrt(f);
      y[i] *= Math.sqrt(f);
      if(x[i]<minx) minx = x[i];
      if(y[i]<miny) miny = y[i];
    }
    for(int i = 0; i < n; i++)
    {
      x[i] -= minx;
      y[i] -= miny;
      System.out.println(x[i] + " " + y[i]);
    }
  }
}
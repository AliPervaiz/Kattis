import java.util.*;
import java.io.*;

public class robotprotection
{
    public static class Polygon
    {
        ArrayList<Point> list;
        public Polygon()
        {
            list = new ArrayList<Point>();
        }
    }
    public static int orientation(Point o, Point a, Point b)
    {
        double cp = (b.subtract(o)).crossProduct(a.subtract(o));
        return cp > EPS ? 1 : (cp < -EPS ? -1 : 0); //PS: change between > 0 or > EPS and < 0 or < -EPS for ints/doubles
    }
    public static Polygon andrewMonotoneChain(Polygon points)
    {
        Collections.sort(points.list);
        Polygon polygon = new Polygon();
        ArrayList<Point> hull = polygon.list;
        for(int i = 0; i < 2; i++)
        {
            int s = hull.size();
            for(Point p : points.list)
            {
                while(hull.size() >= s + 2 && orientation(hull.get(hull.size()-2), hull.get(hull.size()-1), p) == -1)
                    hull.remove(hull.size()-1);
                hull.add(p);
            }
            hull.remove(hull.size()-1);
            Collections.reverse(points.list);
        }
        if(hull.size() == 2 && hull.get(0).equals(hull.get(1))) hull.remove(hull.size()-1);
        return polygon;
    }   
    public static double EPS = 1e-9;
    public static class Point implements Comparable<Point>
    {
        int x;
        int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point o)
        {
            if(Math.abs(o.x-x)<EPS&&Math.abs(o.y-y)<EPS) return 0;
            if(y<o.y || y==o.y&&x<o.x) return -1;
            else return 1;
        }
        public Point add(Point o)
        {
            return new Point(x+o.x,y+o.y);
        }
        public Point subtract(Point o)
        {
            return new Point(x-o.x,y-o.y);
        }
        public double crossProduct(Point o)
        {
            return x*o.y - y*o.x;
        }
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true)
        {
            int n = Integer.parseInt(input.readLine());
            if(n==0) break;
            Polygon polygon = new Polygon();
            for(int i = 0; i < n; i++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                polygon.list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Polygon convexHull = andrewMonotoneChain(polygon);
            double area = 0;
            for(int i = 0; i < convexHull.list.size(); i++)
            {
                if(i==0) area -= convexHull.list.get(i).x * convexHull.list.get(convexHull.list.size()-1).y;
                else area -= convexHull.list.get(i).x * convexHull.list.get(i-1).y;
                if(i==convexHull.list.size()-1) area += convexHull.list.get(i).x * convexHull.list.get(0).y;
                else area += convexHull.list.get(i).x * convexHull.list.get(i+1).y;
            }
            out.println(String.format("%.1f",Math.abs(area/2)));
        }
        out.flush();
        out.close();
    }
}
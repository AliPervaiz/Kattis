import java.util.*;
import java.io.*;

public class romanholidays
{
    public static class Node implements Comparable<Node>
    {
        int i;
        String s;
        public Node(int i, String s)
        {
            this.i = i;
            this.s = s;
        }
        public int compareTo(Node o)
        {
            return s.compareTo(o.s);
        }
        public String toString()
        {
            return s + " " + i;
        }
    }
    public static String roman(int i)
    {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(6,"VI");
        map.put(7,"VII");
        map.put(8,"VIII");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(20,"XX");
        map.put(30,"XXX");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(60,"LX");
        map.put(70,"LXX");
        map.put(80,"LXXX");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(200,"CC");
        map.put(300,"CCC");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(600,"DC");
        map.put(700,"DCC");
        map.put(800,"DCCC");
        map.put(900,"CM");
        String ans = "";
        while(i>=1000)
        {
            ans += "M";
            i -= 1000;
        }
        if(i>=100) ans += map.get(i/100*100);
        i %= 100;
        if(i>=10) ans += map.get(i/10*10);
        i %= 10;    
        if(i>=1) ans += map.get(i);
        return ans;
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 1; i <= 1001; i++) pq.add(new Node(i, roman(i)));
        for(int i = 1; i <= 1001; i++)
        {
            Node nod = pq.poll();
            if(nod.s.charAt(0)=='V'||nod.s.charAt(0)=='X') map.put(nod.s,i-1002);
            else map.put(nod.s,i);
        }
        //out.println(map);
        int n = Integer.parseInt(input.readLine());
        while(n-->0)
        {
            int num = Integer.parseInt(input.readLine());
            String rNum = roman(num%1000);
            int type = 1;
            if(rNum.length()>0&&(rNum.charAt(0)=='V'||rNum.charAt(0)=='X')) type = -1;
            if(type==1)
            {
                int ans = 946 * (num/1000);
                if(map.containsKey(rNum)) ans += map.get(rNum);
                out.println(ans);
            }
            else
            {
                int ans = 0;
                ans += -54 * (num/1000);
                if(map.containsKey(rNum)) ans += map.get(rNum);
                out.println(ans);
            }
        }
        out.flush();
        out.close();
    }
}
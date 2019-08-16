import java.util.*;
import java.io.*;
import java.math.*;

public class leftandright
{
    public static class Node
    {
        int i;
        Node left;
        Node right;
        public Node(int i)
        {
            this.i = i;
            left = null;
            right = null;
        }
        public void addRight(Node nod)
        {
            right = nod;
            nod.left = this;
        }
        public void addLeft(Node nod)
        {
            Node temp = left;
            left = nod;
            nod.right = this;
            nod.left = temp;
            if(temp!=null) temp.right = nod;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        input.readLine();
        String dir = input.readLine();
        Node curr = new Node(1);
        Node lm = curr;
        Node rm = curr;
        for(int i = 2; i <= dir.length()+1; i++)
        {
            Node nod = new Node(i);
            if(dir.charAt(i-2)=='R')
            {
                rm.addRight(nod);
                rm = nod;
                curr = nod;
            }
            else
            {
                curr.addLeft(nod);
                if(lm==curr) lm = nod;
                curr = nod;
            }
        }
        while(lm!=null)
        {
            out.println(lm.i);
            lm = lm.right;
        }
        out.flush();
        out.close();
    }
}
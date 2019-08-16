import java.util.*;
import java.io.*;
import java.math.*;

public class supercomputer
{
  public static class SegmentTree
  {
    int[] tree;
    int N;
    public SegmentTree(int[] ar)
    {
        N = ar.length;
        tree = new int[N*2];
        for(int i = 0; i < ar.length; i++) tree[i+N] = ar[i];
        for(int i = N-1; i > 0; i--) tree[i] = tree[i << 1] + tree[i << 1 | 1];
    }
    public void flip(int i)
    {
        tree[i+N] ^= 1;
        for(i = (i+N)>>1; i >= 1; i >>= 1) tree[i] = tree[i << 1] + tree[i << 1 | 1];
    }
    public int sum(int l, int r)
    {
        int sum = 0;
        for(l += N, r += N; l < r; l >>= 1, r >>= 1)
        {
            if(l%2==1) sum += tree[l++];
            if(r%2==1) sum += tree[--r];
        }
        return sum;
    }
  }
  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(input.readLine());
    int N = Integer.parseInt(st.nextToken());
    SegmentTree tree = new SegmentTree(new int[N]);
    int Q = Integer.parseInt(st.nextToken());
    while(Q-->0)
    {
      st = new StringTokenizer(input.readLine());
      if(st.nextToken().equals("F"))
        tree.flip(Integer.parseInt(st.nextToken())-1);
      else
        out.println(tree.sum(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));  
    }
    out.flush();
    out.close();
  }
}
import java.util.*;
import java.io.*;

public class wiknow
{
    public static class SegmentTree
    {
        int[] a;
        int[] tree;
        public SegmentTree(int[] a)
        {
            this.a = a;
            tree = new int[4*a.length];
            Arrays.fill(tree,Integer.MAX_VALUE);
        }
        public void update(int i, int k, int l, int r)
        {
            if(l+1==r) tree[k] = a[i];
            else
            {
                int m = l+r>>1;
                if(i<m) update(i,k<<1,l,m);
                else update(i,(k<<1)+1,m,r);
                tree[k] = Math.min(tree[k<<1],tree[(k<<1)+1]);
            } 
        }
        public int query(int i, int j, int k, int l, int r)
        {
            if(l==r) return Integer.MAX_VALUE;
            if(i<=l&&j>=r) return tree[k];
            int m = l+r>>1;
            int min = Integer.MAX_VALUE;
            if(i<m) min = Math.min(min,query(i,j,k<<1,l,m));
            if(j>m) min = Math.min(min,query(i,j,(k<<1)+1,m,r));
            return min;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int N = Integer.parseInt(input.readLine());
        int[] a = new int[N];
        int[] next = new int[N];
        int[] right = new int[N+1];
        for(int i = 0; i < N; i++) a[i] = Integer.parseInt(input.readLine());
        SegmentTree st = new SegmentTree(a);
        for(int i = N-1; i >= 0; i--)
        {
            next[i] = right[a[i]];
            right[a[i]] = i;
        }
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++)
        {
            if(next[i]==0) continue;
            int v = st.query(i+1,next[i],1,1,N+1);
            if(v<minA)
            {
                minA = v;
                minB = a[i];
            }
            if(v==minA) minB = Math.min(minB,a[i]);
            st.update(next[i],1,1,N+1);
        }
        if(minA==Integer.MAX_VALUE) out.println(-1);
        else out.println(minA + " " + minB);
        out.flush();
        out.close();
    }
}
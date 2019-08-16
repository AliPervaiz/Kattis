import java.util.*;
import java.io.*;
public class closestsums
{
    public static void main(String[] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        int t = 0;
        while(input.hasNextInt())
        {
            t++;
            int n = input.nextInt();
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) ar[i] = input.nextInt();
            Set<Integer> set = new TreeSet<Integer>();
            for(int r = 0; r < n; r++)
                for(int c = r+1; c < n; c++)
                    set.add(ar[r]+ar[c]);
            ArrayList<Integer> list = new ArrayList<Integer>();     
            for(int i : set) list.add(i);
            System.out.println("Case " + t + ":");
            int q = input.nextInt();        
            for(int i = 0; i < q; i++)
            {
                int j = input.nextInt();
                int index = Collections.binarySearch(list,j);
                if(index<0) index = -index-1;
                int closest = -1;
                if(index>0) closest = list.get(index-1);
                if(index<list.size()&&(Math.abs(j-list.get(index))<Math.abs(j-closest))||closest==-1) closest = list.get(index);
                if(index+1<list.size()&&(Math.abs(j-list.get(index+1))<Math.abs(j-closest))||closest==-1) closest = list.get(index+1);
                System.out.println("Closest sum to " + j + " is " + closest + ".");
            }       
        }
    }
}
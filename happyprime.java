import java.util.*;
import java.io.*;
public class happyprime
{
    public static void main(String[] args)throws IOException
    {
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        boolean prime[] = new boolean[10001];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int r = 2; r < prime.length; r++)
            if(prime[r])
                for(int c = r*2; c < prime.length; c+=r)
                    prime[c] = false;
        int[] happy = new int[10001];           
        while(tc-->0)
        {
            int t = input.nextInt();
            int n = input.nextInt();
            if(!prime[n])
                System.out.println(t + " " + n + " NO");
            else
            {
                if(happy[n] == 0)
                {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(n);
                    boolean happ = true;
                    int temp = n;
                    while(true)
                    {
                        String s = temp+"";
                        int sum = 0;
                        for(int i = 0; i < s.length(); i++)
                            sum += Math.pow(Integer.parseInt(s.substring(i,i+1)),2);
                        if(sum==1)
                            break;
                        else if(list.contains(sum))
                        {
                            happ = false;
                            break;
                        }
                        else
                        {
                            list.add(sum);
                            temp = sum;
                        }       
                    }
                    for(int i : list)
                    {
                        if(happ) happy[i] = 1;
                        else happy[i] = -1;
                    }       
                }
                if(happy[n] == -1)
                    System.out.println(t + " " + n + " NO");
                else
                    System.out.println(t + " " + n + " YES");   
            }   
        }
    }
}
import java.util.*;
import java.io.*;
import java.math.*;
public class listgame {
  public static boolean isPrime(int n)
  {
    return new BigInteger(n+"").isProbablePrime(100);
  }
  public static void main(String[] args)throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(
                                  new OutputStreamWriter(System.out, "UTF-8")));
    boolean[] prime = new boolean[10000001];
    Arrays.fill(prime,true);
    prime[0] = false;
    prime[1] = false;
    for(int r = 2; r < prime.length; r++)
      if(prime[r])
        for(int c = r*2; c < prime.length; c+=r)
          prime[c] = false;     
    int n = Integer.parseInt(input.readLine());
    int ans = 0;
    if(n<prime.length&&prime[n]||isPrime(n))
      ans = 1;
    else
    {
      int p = 1;
      while(n!=1)
      {
        if(n<prime.length&&prime[n]||isPrime(n))
        {
          ans += 1;
          break;
        }
        p++;
        while(p<prime.length&&!prime[p]||!isPrime(p)) p++;
        int sum = 0;
        while(n%p==0)
        {
          n/=p;
          sum++;
        }
        ans += sum;
      }
    }
    out.println(ans);
    out.close();
  }  
}
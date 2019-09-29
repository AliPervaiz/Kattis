import java.util.*;
import java.io.*;
import java.math.*;

public class sgcoin
{
    public static long H(long previousHash, String transaction, long token) 
    {
        long v = previousHash;
        for (int i = 0; i < transaction.length(); i++) v = (v * 31 + transaction.charAt(i)) % 1000000007;
        return (v * 7 + token) % 1000000007;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        long prevHash = Long.parseLong(input.readLine());
        for(int i = 0; i < 2; i++)
        {
            long bad = (prevHash*31+'a')%1000000007*7;
            BigInteger bi = new BigInteger(bad+"");
            BigInteger mod = new BigInteger("1000000007");
            BigInteger modI = bi.modInverse(mod);
            BigInteger nine = new BigInteger("9999999");
            BigInteger fam = bi.multiply(modI).add(nine);
            BigInteger token = fam.subtract(bi).mod(mod);
            long tokenl = Long.parseLong(token.toString());
            out.println("a " + tokenl);
            prevHash = H(prevHash,"a",tokenl);
        }
        out.flush();
        out.close();
    }
}
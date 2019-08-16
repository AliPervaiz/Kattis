import java.util.*;
import java.io.*;

public class ignore
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt())
        {
            int n = input.nextInt();
            String b7 = Integer.toString(n,7);
            String ans2 = "";
            for(int c = 0; c < b7.length(); c++)
            {
                if(b7.charAt(c)=='3') ans2 = "5"+ans2;
                else if(b7.charAt(c)=='4') ans2 = "9"+ans2;
                else if(b7.charAt(c)=='5') ans2 = "8"+ans2;
                else ans2 = b7.charAt(c)+ans2;
            }
            System.out.println(ans2);
        }
    }
}
import java.util.*;
import java.io.*;

public class bishops
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt())
        {
            int n = input.nextInt();
            if(n==0||n==1) System.out.println(n);
            else System.out.println(n*2-2);
        }
    }
}
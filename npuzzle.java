import java.util.*;
import java.io.*;

public class npuzzle
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int diff = 0;
        for(int r = 0; r < 4; r++)
        {
            String line = input.next();
            for(int c = 0; c < 4; c++)
            {
                if(line.charAt(c)!='.')
                {
                    int R = (line.charAt(c)-'A')/4;
                    int C = (line.charAt(c)-'A')%4;
                    diff += Math.abs(R-r) + Math.abs(C-c);
                }
            }
        }
        System.out.println(diff);
    }
}
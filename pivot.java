import java.util.*;
import java.io.*;
public class pivot {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ar1 = new int[n];
    int[] ar2 = new int[n];
    for(int i = 0; i < n; i++)
    {
      ar1[i] = input.nextInt();
      ar2[i] = ar1[i];
    }
    Arrays.sort(ar2);
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++)
    {
      if(ar1[i]==ar2[i]&&max<ar1[i])
        sum++;
      max = Math.max(max,ar1[i]);  
    }
    System.out.println(sum);    
  }
}
import java.util.*;
import java.io.*;
public class backspace {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String s = input.next();
    Stack<Character> stack = new Stack<Character>();
    for(int c = 0; c < s.length(); c++)
    {
      if(s.charAt(c)=='<') stack.pop();
      else stack.add(s.charAt(c));
    }
    System.out.println(stack.toString().replace(", ","").replace("[","").replace("]",""));
  }  
}
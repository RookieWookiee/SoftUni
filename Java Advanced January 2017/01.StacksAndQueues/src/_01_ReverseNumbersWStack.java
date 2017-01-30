
import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbersWStack {
    
    public static void main(String[] args) {
        Stack stack = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        
        for(String str: input)
            stack.add(str);
        
        while(stack.isEmpty() == false) {
            System.out.print(stack.pop().toString() + " ");
        }
    }
}

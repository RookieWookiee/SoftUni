
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _03_MaxElem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        Stack<Integer> maxElements = new Stack();
        int maxVal = Integer.MIN_VALUE;
        
        
        int lines = Integer.parseInt(in.nextLine());
        for(int i = 0; i < lines; ++i) {
            String[] input = in.nextLine().split(" ");
            switch(input[0]) {
                case "1":
                    int num = Integer.parseInt(input[1]);
                    stack.push(num);
                    if(num >= maxVal)
                    {
                        maxVal = num;
                        maxElements.push(num);
                    }
                    break;
                case "2":
                    if(maxVal == stack.pop()) {
                        maxElements.pop();
                        if(!maxElements.isEmpty())
                            maxVal = maxElements.peek();
                        else
                            maxVal = Integer.MIN_VALUE;
                    }
                    break;
                case "3":
                    System.out.println(maxElements.peek());
                    break;
            }
        }
    }
}

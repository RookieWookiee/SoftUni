
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _03_MaxElem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack();
        ArrayList output = new ArrayList<Integer>();
        
        int lines = Integer.parseInt(in.nextLine());
        for(int i = 0; i < lines; ++i) {
            String input = in.nextLine();
            switch(input.charAt(0)) {
                case '1':
                    stack.add(Integer.parseInt(input.split(" ")[1]));
                    break;
                case '2':
                    stack.pop();
                    break;
                case '3':
                    Stack temp = (Stack)stack.clone();
                    temp.sort(null);
                    output.add(temp.pop());
                    break;
            }
        }
        output.forEach((ob) -> {
            System.out.println(ob);
        });
    }
}

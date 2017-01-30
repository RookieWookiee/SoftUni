
import java.util.Scanner;
import java.util.Stack;

public class _02_BasicStackOp {
    
    static int numOfElems;
    static int popRequest;
    static int checkIfContain;
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack<>();
        
        numOfElems = in.nextInt();
        popRequest = in.nextInt();
        checkIfContain = in.nextInt();
        
        for(int i = 0; i < numOfElems; ++i) 
            stack.add(in.nextInt());
        
        for(int i = 0; i < popRequest; ++i) 
            stack.pop();
        
        if(stack.contains(checkIfContain)) 
            System.out.println("true");
        else if(stack.isEmpty())
            System.out.println("0");
        else {
            stack.sort(null);
            System.out.println(stack.get(0));
        }
            
    }
}

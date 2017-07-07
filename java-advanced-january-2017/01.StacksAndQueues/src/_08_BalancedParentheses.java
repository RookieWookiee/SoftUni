
import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BalancedParentheses {
    public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        ArrayDeque<Character> deck = new ArrayDeque(); //Could've used a Stack
        char[] arr = in.nextLine().toCharArray();
        
        for(int i = 0; i < arr.length; ++i) {
            switch(arr[i]) {
                case '(': case '[': case '{':
                    deck.addLast(arr[i]);
                    break;
                case ')': case ']': case '}':
                    if(deck.isEmpty() || arr[i] != invertParentheses(deck.peekLast())) {
                        System.out.println("NO");
                        return;
                    }
                    deck.removeLast();
                    break;
            }
        }
        if(deck.isEmpty()) System.out.println("YES");
    }

    private static char invertParentheses(char c) {
        switch(c) {
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
        }
        return 0;
    }
}

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_SequenceWQueue {
    
    public static void main(String[] args) {
        ArrayDeque<Long> deck = new ArrayDeque();
        Scanner in = new Scanner(System.in);
        
        deck.addFirst(in.nextLong());
        
        for(int i = 0; i < 50; ++i) {
            Long curr = deck.getFirst();
            
            System.out.print(curr + " ");
            
            Long s1 = curr + 1;
            Long s2 = 2 * curr + 1;
            Long s3 = curr + 2;
            
            deck.add(s1);
            deck.add(s2);
            deck.add(s3);
            
            deck.removeFirst();
        }
    }
}

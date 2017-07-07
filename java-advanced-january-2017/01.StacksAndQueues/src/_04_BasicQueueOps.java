
import java.util.*;

public class _04_BasicQueueOps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<Integer> deck = new ArrayDeque<>();
		String[] s = sc.nextLine().split("\\s+");
		
		int in = Integer.parseInt(s[0]);
		int out = Integer.parseInt(s[1]);
		int contain = Integer.parseInt(s[2]);
		
		s = sc.nextLine().split(" ");
		
		for(int i = 0; i < in; i++) {
			deck.add(Integer.parseInt(s[i]));
		}
		
		for(int i = 0; i < out; i++) {
			deck.remove();
		}
		
		if(deck.contains(contain)) System.out.println("true");
		else {
			
			int smallest = deck.isEmpty() ? 0 : Integer.MAX_VALUE;
			for(;!deck.isEmpty();) {
				int val = deck.remove();
				if(val < smallest)
					smallest = val;
			}
			System.out.println(smallest);
		}
	}
}

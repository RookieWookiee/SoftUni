
import java.util.Scanner;
import java.util.Stack;

public class _11_SimpleTextEditor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder bld = new StringBuilder(); 
		Stack<String> history = new Stack();
		String[] tokens = null;
		Boolean undoSwitch = false;
		
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; ++i) {
			if (!undoSwitch) {
				tokens = sc.nextLine().split(" ");
			}
			switch (tokens[0]) {
				case "1": //append some String to the end
					bld.append(tokens[1]);
					//If undo was invoked don't add the opposite of the command to the history
					if (!undoSwitch) { 
						history.push("2 " + tokens[1].length());
					}
					undoSwitch = false;
					break;
				case "2": //Erase 'num' count of elements from the end
					int num = Integer.parseInt(tokens[1]);
					int len = bld.length();
					if (!undoSwitch) {
						history.add("1 " + bld.substring(len - num, len));
					}
					undoSwitch = false;
					bld.delete(len - num, len);
					break;
				case "3": // Contains 
					System.out.println(bld.charAt(Integer.parseInt(tokens[1]) - 1));
					break;
				case "4": //Undo;
					undoSwitch = true;
					tokens = history.pop().split(" ");
					++n;
					break;
			}
		}
	}
}


import java.util.*;

public class _11_SimpleTextEditor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringBuilder bld = new StringBuilder("");
		Stack<String> history = new Stack();
		String[] input = null;
		Boolean inputSwitch = false;

		for (int i = 0; i < n; ++i) {
			if (!inputSwitch) {
				input = sc.nextLine().split(" ");
			}
			switch (input[0]) {
				case "1":
					bld.append(input[1]);
					if (!inputSwitch) {
						history.push("2 " + input[1].length());
					}
					inputSwitch = false;
					break;
				case "2":
					int num = Integer.parseInt(input[1]);
					int len = bld.length();
					if (!inputSwitch) {
						history.add("1 " + bld.substring(len - num, len));
					}
					inputSwitch = false;
					bld.delete(len - num, len);
					break;
				case "3":
					System.out.println(bld.charAt(Integer.parseInt(input[1]) - 1));
					break;
				case "4":
					inputSwitch = true;
					input = history.pop().split(" ");
					++n;
					break;
			}
		}
	}
}


import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class _13_EvaluateExpression {

	private static final String NUM_OR_VAR = "[a-z0-9]+";
	private static final String NUM = "[0-9]+";
	private static final String OPERATORS = "[*+-/]";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = _12_InfixToPostfix.infixToPrefix(sc.nextLine());
		System.out.format("%.2f\n", EvaluatePrefix(result));
	}

	public static Double EvaluatePrefix(String prefix) {
		String[] s = prefix.split(" ");
		Stack<Double> output = new Stack();
		Stack<String> opStack = new Stack();

		for (int i = 0; i < s.length; ++i) {
			if (Pattern.matches(NUM, s[i])) {
				output.push(Double.parseDouble(s[i]));
			}
			if (Pattern.matches(OPERATORS, s[i])) {
				Double y = output.pop();
				Double x = output.pop();
				switch (s[i]) {
					case "+":
						output.push(x + y);
						break;
					case "-":
						output.push(x - y);
						break;
					case "*":
						output.push(x * y);
						break;
					case "/":
						output.push(x / y);
						break;
				}
			}
		}
		return output.pop();
	}
}

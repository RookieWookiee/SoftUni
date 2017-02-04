
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class _13_EvaluateExpression {

	private static final String NUM_OR_VAR = "[a-z0-9]+";
	private static final String NUM = "[0-9]+";
	private static final String OPERATORS = "[*+-/]";
	private static final String SPLIT_DELIM = "\\s+";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String prefix = _12_InfixToPostfix.infixToPrefix(sc.nextLine());
		System.out.format("%.2f\n", EvaluatePrefix(prefix));
	}

	public static Double EvaluatePrefix(String prefix) {
		String[] tokens = prefix.split(SPLIT_DELIM);
		Stack<Double> output = new Stack();
		Stack<String> opStack = new Stack();

		for (int i = 0; i < tokens.length; ++i) {
			if (Pattern.matches(NUM, tokens[i])) {
				output.push(Double.parseDouble(tokens[i]));
			}
			if (Pattern.matches(OPERATORS, tokens[i])) {
				Double y = output.pop();
				Double x = output.pop();
				switch (tokens[i]) {
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

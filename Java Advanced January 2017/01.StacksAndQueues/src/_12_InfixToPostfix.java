
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_InfixToPostfix {

	private static final String NUM_OR_VAR = "[a-z1-9]+";
	private static final String OPERATORS = "[*+-/]";

	public static void main(String[] args) {
		_12_InfixToPostfix obj = new _12_InfixToPostfix();
		obj.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<String> outputQ = new ArrayDeque();
		Stack<Operator> opStack = new Stack();
		String[] input = sc.nextLine().split(" ");

		for (int i = 0; i < input.length; ++i) {
			if (Pattern.matches(NUM_OR_VAR, input[i])) {
				outputQ.add(input[i]);
			} else if (Pattern.matches(OPERATORS, input[i])) {
				Operator op = new Operator(input[i]);
				if (!opStack.isEmpty()) {
					while (opStack.size() > 0
						&& op.getPrecedence() <= opStack.peek().getPrecedence()) {
						Operator o = opStack.pop();
						if (!o.symbol.equals("(")) {
							outputQ.add(o.toString());
						}
					}
				}
				opStack.push(op);
			} else if (input[i].equals("(")) {
				opStack.push(new Operator("("));
			} else if (input[i].equals(")")) {
				Operator op = opStack.pop();
				while (!op.symbol.equals("(")) {
						outputQ.add(op.toString());
						op = opStack.pop();
				}
			}
			

		}
		while (opStack.size() > 0) {
			outputQ.add(opStack.pop().symbol);
		}

		System.out.println(String.join(" ", outputQ));
	}

	private class Operator {

		byte precedence;
		String symbol;

		byte getPrecedence() {
			return this.precedence;
		}

		Operator(String symbol) {
			this.symbol = symbol;
			switch (symbol) {
				case "*":
				case "/":
					this.precedence = 3;
					break;
				case "+":
				case "-":
					this.precedence = 2;
					break;
				case "(":
				case ")":
					break;
			}
		}

		@Override
		public String toString() {
			return this.symbol;
		}
	}
}

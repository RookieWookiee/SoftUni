
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Pattern;

public class _12_InfixToPostfix {

	private static final String NUM_OR_VAR = "[a-z1-9]+";
	private static final String OPERATORS = "[*+-/]";
	private static final String SPLIT_DELIM = "\\s+";

	public static void main(String[] args) {
		_12_InfixToPostfix obj = new _12_InfixToPostfix();
		obj.run();
	}
	public static String infixToPrefix(String infix) {
		ArrayDeque<String> outputQ = new ArrayDeque();
		Stack<Operator> opStack = new Stack();
		String[] tokens = infix.split(SPLIT_DELIM);

		for (int i = 0; i < tokens.length; ++i) {
			if (Pattern.matches(NUM_OR_VAR, tokens[i])) {
				outputQ.add(tokens[i]);
			} else if (Pattern.matches(OPERATORS, tokens[i])) {
				Operator op = new Operator(tokens[i]);
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
			} else if (tokens[i].equals("(")) {
				opStack.push(new Operator("("));
			} else if (tokens[i].equals(")")) {
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
		
		return String.join(" ", outputQ);
	}
	public void run() {
		Scanner sc = new Scanner(System.in);
		String prefix = infixToPrefix(sc.nextLine());
		System.out.println(prefix);
	}

	private static class Operator {

		byte precedence;
		String symbol;

		byte getPrecedence() {
			return this.precedence;
		}

		Operator(String symbol) {
			this.symbol = symbol;
			switch (symbol) {
				case "*": case "/":	this.precedence = 3; break;
				case "+": case "-":	this.precedence = 2; break;
			}
		}

		@Override
		public String toString() {
			return this.symbol;
		}
	}
}

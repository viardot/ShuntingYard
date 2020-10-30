package ShuntingYard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class ReversePolishNotation {
	
	private Deque<String> input;
	private Deque<Double> operandsQueue = new LinkedList<>();
	private final Set<String> operators = Set.of("+", "-", "x", "/", "%", "^");
	
	public ReversePolishNotation () {
		// do Nothing
	}

	public ReversePolishNotation (Deque<String> input) {
		this.input = input;
	}

	public Deque<String> getInput() {
		return input;
	}

	public void setInput(Deque<String> input) {
		this.input = input;
	}

	public Double solveRPN () {
		
	   while (!input.isEmpty()) {
			if (isNumber(input.peekFirst())) {
				operandsQueue.addLast(Double.parseDouble(input.pollFirst()));
			} else if (operators.contains(input.peekFirst())) {
				operandsQueue.addLast(solvePart(input.pollFirst()));
			}
		}
		
		return operandsQueue.pollFirst();
	}
	
	private Double solvePart(String operator) {
		Double part = null;
		Double operand1 = operandsQueue.pollFirst();
		Double operand2 = operandsQueue.pollFirst();
		
		switch (operator) {
		case "+":
	        part = operand1 + operand2;		
			break;
		case "-":
	        part = operand1 - operand2;
			break;
		case "x":
			part = operand1 * operand2;
		    break;
		case "/":
			part = operand1 / operand2;
		    break;
		case "%":
			part = operand1 % operand2;
		    break;
		case "^":
			part = Math.pow(operand1, operand2);
			break;
		default:
		}
		
		return part;
	}

	private Boolean isNumber (String str) {
		
		if (str == null) return false;
		
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		
		return true;
	}
}

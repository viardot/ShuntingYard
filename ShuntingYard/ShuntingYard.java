package ShuntingYard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ShuntingYard {
	
	private String[] input;
	private final Map<String, Integer> precedence = Map.of(
	           "+", 2,
	           "-", 2,
	           "x", 3,
	           "/", 3,
	           "%", 3,
	           "^", 4);
	private final Set<String> leftAssociative  = Set.of("+", "-", "x", "/", "%");
	
	
	public ShuntingYard () {
		//Do nothing
	}

	public ShuntingYard (String input) {
		this.input = input.split(" ");
	}

	public String[] getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input.split(" ");
	}
	
	
	public Deque<String> getRPN () {

		Deque<String> outputQueue = new LinkedList<>();
		Deque<String> operatorStack = new LinkedList<>();

		for (int i = 0; i < input.length; i++) {

			if (isNumber(input[i])) {

				outputQueue.addLast(input[i]);
			
			} else if (precedence.containsKey(input[i])) {

				while (!operatorStack.isEmpty() &&
						isLargerOrEqual(operatorStack.peekFirst(),input[i]) && 
						leftAssociative.contains(input[i]) &&
						!operatorStack.peekFirst().equals("(")) {
					
					outputQueue.addLast(operatorStack.pollFirst());
				}
				operatorStack.addFirst(input[i]);

			} else if (input[i].equals("(")) {

				operatorStack.addFirst(input[i]);
				
			} else if (input[i].equals(")")) { 

			    while (!operatorStack.peekFirst().equals(null) && !operatorStack.peekFirst().equals("(")) {

			    	outputQueue.addLast(operatorStack.pollFirst());
			    }
                
			    operatorStack.pollFirst();
			}
		}
		while (!operatorStack.isEmpty()) {
			outputQueue.addLast(operatorStack.pollFirst());
		}
		
		return  outputQueue;
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

	private Boolean isLargerOrEqual (String first, String str) { 

        if (first.equals("(") || precedence.get(first) >= precedence.get(str)) return true;

		return false;
	}
	
}



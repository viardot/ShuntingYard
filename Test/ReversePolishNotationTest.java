package Test;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationTest {
	
	@Test
	public void instantiateRPN ( ) {
		ShuntingYard.ReversePolishNotation RPN = new ShuntingYard.ReversePolishNotation(); 
		Deque<String> rpnQueue = new LinkedList<>();
		rpnQueue.addLast("3");
		rpnQueue.addLast("4");
		rpnQueue.addLast("-");
		RPN.setInput(rpnQueue);
		Assertions.assertEquals(-1, RPN.solveRPN());
	}
	
	@Test
	public void solveRPN1 ( ) {
		ShuntingYard.ReversePolishNotation RPN = new ShuntingYard.ReversePolishNotation(); 
		Deque<String> rpnQueue = new LinkedList<>();
		rpnQueue.addLast("3");
		rpnQueue.addLast("4");
		rpnQueue.addLast("-");
		rpnQueue.addLast("5");
		rpnQueue.addLast("+");
		RPN.setInput(rpnQueue);
		Assertions.assertEquals(4, RPN.solveRPN());
	}
	

}

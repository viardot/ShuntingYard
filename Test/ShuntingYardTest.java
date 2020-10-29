package Test;

import java.util.Deque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShuntingYardTest {
	
	@Test
	public void instantiateShuntingYardTest() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard();
		Assertions.assertTrue(sy.getClass() == ShuntingYard.ShuntingYard.class);
	}
	
	@Test
	public void instantiateShuntingYardGetInputTest() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard("3 + 4");
		String[] expected = "3 + 4".split(" ");
		for(int i = 0; i < 3; i++) {
			Assertions.assertEquals(expected[i], sy.getInput()[i]);			
		}
	}
	
	@Test
	public void instantiateShuntingYardSetInputTest() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard();
		sy.setInput("3 + 4");
		String[] expected = "3 + 4".split(" ");
		for(int i = 0; i < 3; i++) {
			Assertions.assertEquals(expected[i], sy.getInput()[i]);			
		}
	}
	
	@Test
	public void ShuntingYardReturnRPN_1Test() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard("2 + 3 x 4");
		Deque<String> dq = sy.getRPN();
		String x = new String();
		int limit = dq.size();
		for (int i = 0; i < limit; i++) {
	        if (i == 0) { x = "2"; }
			if (i == 1) { x = "3"; }
			if (i == 2) { x = "4"; }
			if (i == 3) { x = "x"; }
			if (i == 4) { x = "+"; }
			Assertions.assertEquals(x, dq.pollFirst());
		}
	}
	
	@Test
	public void ShuntingYardReturnRPN_2Test() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard("( 2 + 3 ) x 4");
		Deque<String> dq = sy.getRPN();
		String x = new String();
		int limit = dq.size();
		for (int i = 0; i < limit; i++) {
	        if (i == 0) { x = "2"; }
			if (i == 1) { x = "3"; }
			if (i == 2) { x = "+"; }
			if (i == 3) { x = "4"; }
			if (i == 4) { x = "x"; }
			Assertions.assertEquals(x, dq.pollFirst());
		}
	}
	
	@Test
	public void ShuntingYardReturnRPN_3Test() {
		ShuntingYard.ShuntingYard sy = new ShuntingYard.ShuntingYard("3 + 4 x 2 / ( 1 - 5 ) ^ 2 ^ 3");
		Deque<String> dq = sy.getRPN();
		String x = new String();
		int limit = dq.size();
		for (int i = 0; i < limit; i++) {
			if (i == 0 || i == 8)  { x = "3"; } 
            if (i == 1)            { x = "4"; } 
            if (i == 2 || i == 7)  { x = "2"; }
            if (i == 3)            { x = "x"; }
            if (i == 4)            { x = "1"; }
            if (i == 5)            { x = "5"; }
            if (i == 6)            { x = "-"; }
            if (i == 9 || i == 10) { x = "^"; }
            if (i == 11)           { x = "/"; } 
            if (i == 12)           { x = "+"; }
			Assertions.assertEquals(x, dq.pollFirst());
		}
	}
	
	
}

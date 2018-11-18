package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {
	Stack <String> thing=new Stack<String>();
	char c;
	public static void main(String[] args) {
		new _03_TestMatchingBrackets();
	}
	public _03_TestMatchingBrackets() {
		doBracketsMatch("");
	}
	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		
		for (int i = 0; i <b.length() ; i++) {
			c=b.charAt(i);
			if (c=='{') {
			thing.push(b);
			}
			
			if (c=='}') {
			if (thing.isEmpty()) {
				return false;
			}
			else {
			thing.pop();
			}
			
		}
		
		}
		if (thing.isEmpty()) {
			return true;
		}
		else {
			return false;
		
			
		}
		}
}

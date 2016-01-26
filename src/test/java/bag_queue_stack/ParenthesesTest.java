package bag_queue_stack;

import org.junit.Test;

import static bag_queue_stack.Parentheses.isBalanced;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by saagrawal on 1/25/16.
 */
public class ParenthesesTest {

    @Test
    public void validateParentheses() {


        assertFalse(isBalanced(""));
        assertFalse(isBalanced("[}"));
        assertFalse(isBalanced("[{}"));
        assertFalse(isBalanced("[]}"));
        assertFalse(isBalanced("[}]]"));

        assertTrue(isBalanced("[{}]"));
        assertTrue(isBalanced("{}"));
        assertTrue(isBalanced("[]"));
        assertTrue(isBalanced("[()]{}{[()()]()}"));
    }
}

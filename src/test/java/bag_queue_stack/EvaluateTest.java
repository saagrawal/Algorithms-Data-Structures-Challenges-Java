package bag_queue_stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by saagrawal on 1/25/16.
 */
public class EvaluateTest {

    @Test
    public void testValidExpressions() {

        double delta = 0.000001d;
        assertEquals(6.0D, new Evaluate("( 1 + ( 2 + 3 ) )").evaluate(), delta);
        assertEquals(101.0, new Evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )").evaluate(), delta);
    }
}

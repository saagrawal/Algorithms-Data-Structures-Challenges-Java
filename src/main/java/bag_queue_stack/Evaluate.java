package bag_queue_stack;

/**
 * a stack client that evaluates fully parenthesized arithmetic expressions.
 * <p/>
 * It uses Dijkstra's 2-stack algorithm:
 * <ul>
 * <li>Push operands onto the operand stack
 * <li>Push operators onto the operator stack. Ignore left parentheses.
 * <li>On encountering a right parenthesis, pop an operator, pop the requisite number of operands,
 * and push onto the operand stack the result of applying that operator to those operands
 * </ul>
 * </p>
 * Note: the operators, operands, and parentheses must be
 * separated by whitespace. Also, each operation must
 * be enclosed in parentheses. For example, you must write
 * ( 1 + ( 2 + 3 ) ) instead of ( 1 + 2 + 3 ).
 * See EvaluateDeluxe.java for a fancier version.
 * <p/>
 * Remarkably, Dijkstra's algorithm computes the same
 * answer if we put each operator *after* its two operands
 * instead of *between* them.
 *
 * @see <a href="http://algs4.cs.princeton.edu/13stacks/Evaluate.java.html">http://algs4.cs.princeton.edu/13stacks/Evaluate.java.html</a>
 */
public class Evaluate {

    private String expression;

    private Stack<String> operators;
    private Stack<Double> values;

    public Evaluate(String expression) {
        this.expression = expression;

        this.operators = new Stack<String>();
        this.values = new Stack<Double>();
    }

    /**
     * evaluates fully parenthesized arithmetic expressions using Dijkstra's 2-stack algorithm
     *
     * @return -
     */
    public double evaluate() {
        if (expression == null || expression.trim().equals("")) return 0d;

        for (String s : expression.trim().split(" ")) {
            if ("(".equals(s)) {
                //ignore
            } else if ("+".equals(s) || "*".equals(s)) {
                operators.push(s);
            } else if (")".equals(s)) {

                String operator = operators.pop();
                if ("+".equals(operator)) {
                    values.push(values.pop() + values.pop());
                } else if ("*".equals(operator)) {
                    values.push(values.pop() * values.pop());
                }
            } else {
                values.push(Double.valueOf(s));
            }
        }
        return values.pop();
    }
}

package bag_queue_stack;


/**
 * Write a stack client Parentheses that reads in a text stream from standard input
 * and uses a stack to determine whether its parentheses are properly balanced.
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 * <p/>
 * Created by saagrawal on 12/30/15.
 */
public class Parentheses {


    private static boolean isOpenBracket(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private static boolean isCloseBracket(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    /**
     * method to determine whether its parentheses are properly balanced.
     *
     * @return - true if its parentheses are properly balanced; false otherwise
     */
    public static boolean isBalanced(String text) {

        Stack<Character> openBracketStack = new Stack<Character>();


        if (text == null || "".equals(text.trim())) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isOpenBracket(c)) {
                openBracketStack.push(c);
            } else if (isCloseBracket(c)) {
                if (openBracketStack.isEmpty()) return false;

                Character open = openBracketStack.pop();

                if (open == '[' && c != ']') return false;
                if (open == '{' && c != '}') return false;
                if (open == '(' && c != ')') return false;


            } else {
                return false;
            }
        }
        return openBracketStack.isEmpty();

    }


}

package bag_queue_stack;

/**
 * A stack is a collection of objects that are inserted and removed according to the last-in, first-out (LIFO) principle.
 * A user may insert objects into a stack at any time, but may only access or remove the most recently inserted object that remains (at the so-called “top” of
 * the stack)
 * <p/>
 * When you click a hyperlink, your browser displays the new page (and pushes onto a stack).
 * You can keep clicking on hyperlinks to visit new pages, but you can always revisit the previous page by clicking the back button (popping it from the stack).
 * Or Stack can be used for reversing an Array
 *
 * @author saagrawal
 */
public class Stack<E> {

    /*this is a Singly Linked list based implementation*/
    private SNode<E> head;

    private int size = 0;


    /**
     * Adds element e to the top of the stack.
     *
     * @param e - element to add
     */
    public void push(E e) {
        head = new SNode<E>(e, head);
        size++;
    }

    /**
     * Removes and returns the top element from the stack (or null if the stack is empty).
     *
     * @return - Removes and returns the top element from the stack (or null if the stack is empty).
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        } else {
            E e = head.item;
            head = head.next;
            size--;
            return e;
        }

    }

    /**
     * Returns the top element of the stack, without removing it (or null if the stack is empty).
     *
     * @return - Returns the top element of the stack, without removing it (or null if the stack is empty).
     */
    public E top() {
        return !isEmpty() ? head.item : null;
    }

    /**
     * Returns true if the stack is empty, and false otherwise.
     *
     * @return - Returns true if the stack is empty, and false otherwise.
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return - Returns the number of elements in the stack
     */
    public int size() {
        return size;
    }

    private static class SNode<E> {

        private E item;
        private SNode<E> next;

        public SNode(E item, SNode<E> next) {
            this.item = item;
            this.next = next;
        }

        public SNode(E item) {
            this(item, null);
        }
    }

}

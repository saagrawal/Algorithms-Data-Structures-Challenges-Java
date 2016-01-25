package linked_list;

/**
 * A linked list, in its simplest form, is a collection of nodes that collectively form a linear sequence.
 * In a singly linked list, each node stores a reference to an object that is an element of the sequence, as well as a reference to the next node of the list
 * <p/>
 * In this implementation, we will use both head and tail (to support adding and removing at the end) pointers
 *
 * @author saagrawal
 */
public class SinglyLinkedList<E> {

    private int size = 0;
    private SListNode<E> head;

    /**
     * tail pointer is used to support adding and removing at the end without link hooping
     */
    private SListNode<E> tail;

    /**
     * Adds a new element to the front of the list.
     *
     * @param e - item to add
     */
    public void addFirst(E e) {
        head = new SListNode<E>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param e - item to add
     */
    public void addLast(E e) {
        SListNode<E> newNode = new SListNode<E>(e, null);
        if (tail == null) {
            tail = new SListNode<E>(e, null);
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * Removes and returns the first element of the list
     *
     * @return - Removes and returns the first element of the list
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            E item = head.item;
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return item;
        }

    }

    /**
     * Returns (but does not remove) the last element in the list.
     *
     * @return - Returns (but does not remove) the last element in the list.
     */
    public E last() {
        return tail != null ? tail.item : null;

    }

    /**
     * Returns (but does not remove) the first element in the list.
     *
     * @return - Returns (but does not remove) the first element in the list.
     */
    public E first() {
        return head != null ? head.item : null;
    }

    /**
     * Returns true if the list is empty, and false otherwise.
     *
     * @return - Returns true if the list is empty, and false otherwise.
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return - Returns the number of elements in the list
     */
    public int size() {
        return size;
    }


    /**
     * R-3.6: Give an algorithm for finding the second-to-last node in a singly linked list in which the last node
     * is indicated by a null next reference
     *
     * @return - second to last node
     */
    public E findSecondToLastNode() {
        if (head == null || size() < 2) {
            return null;
        } else if (size() == 2) {
            return head.item;
        } else {
            SListNode<E> previous = head;
            SListNode<E> next = head.next;

            while (next != null) {
                previous = next;
                next = next.next;
            }
            return previous.item;
        }
    }

    private static class SListNode<E> {

        private E item;
        private SListNode<E> next;

        public SListNode(E item, SListNode<E> next) {
            this.item = item;
            this.next = next;
        }

        public SListNode(E item) {
            this(item, null);
        }
    }
}

package linked_list;

/**
 * There are many applications in which data can be more naturally viewed as having a cyclic order, with well-defined neighboring relationships,
 * but no fixed beginning or end. For example, many multiplayer games are turn-based, with player A taking a turn,
 * then player B, then player C, and so on, but eventually back to player A again, and player B again, with the pattern repeating.
 * As another example, city buses and subways often run on a continuous loop, making stops in a scheduled order,
 * but with no designated first or last stop per se. We next consider another important example of a cyclic order in the context of computer operating systems.
 * <p/>
 * As another example, Round-Robin Scheduling - Each active process is given its own time slice, taking turns in a cyclic order.
 * New processes can be added to the system, and processes that complete their work can be removed.
 * <p/>
 * We use this model to design and implement a new CircularlyLinkedList class, which supports all of the public behaviors of our SinglyLinkedList class
 * and one additional update method: rotate():	Moves the first element to the end of the list.
 * With this new operation, round-robin scheduling can be efficiently implemented by repeatedly performing the following steps on a circularly linked list C:
 * Give a time slice to process C.first(); C.rotate()
 *
 * @author saagrawal
 */
public class CircularLinkedList<E> {

    private int size = 0;

    /**
     * In implementing a new class, we make one additional optimization—we no longer explicitly maintain the head reference.
     * So long as we maintain a reference to the tail, we can locate the head as tail.getNext().
     * Maintaining only the tail reference not only saves a bit on memory usage, it makes the code simpler and more efficient,
     * as it removes the need to perform additional operations to keep a head reference current.
     * In fact, our new implementation is arguably superior to our original singly linked list implementation, even if we are not interested in the new rotate method
     */
    private SListNode<E> tail;


    /**
     * Moves the first element to the end of the list.
     * We do not move any nodes or elements, we simply advance the tail reference to point to the node that follows it (the implicit head of the list).
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        }
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param e - item to add
     */
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new SListNode<E>(e, null);
            tail.next=tail;
        } else {
            tail.next = new SListNode<E>(e, tail.next);
        }
        size++;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param e - item to add
     */
    public void addLast(E e) {
        if (isEmpty()) {
            tail = new SListNode<E>(e, null);
            tail.next = tail;
        } else {
            SListNode<E> newNode = new SListNode<E>(e, tail.next);
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
            E item = null;
            if (tail.next == null) {
                item = tail.item;
            } else {
                item = tail.next.item;
                tail.next = tail.next.next;
            }
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
        return isEmpty() ? null : tail.next.item;
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

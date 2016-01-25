package linked_list;

/**
 * There are limitations that stem from the asymmetry of a singly linked list.
 * we can efficiently insert a node at either end of a singly linked list, and can delete a node at the head of a list,
 * but we are unable to efficiently delete a node at the tail of the list.
 * More generally, we cannot efficiently delete an arbitrary node from an interior position of the list if only given a reference to that node,
 * because we cannot determine the node that immediately precedes the node to be deleted (yet, that node needs to have its next reference updated).
 * <p/>
 * To provide greater symmetry, we define a linked list in which each node keeps an explicit reference to the node before it and a reference to the node after it.
 * Such a structure is known as a doubly linked list. These lists allow a greater variety of O(1)-time update operations, including insertions
 * and deletions at arbitrary positions within the list.
 *
 * @author saagrawal
 */
public class DoublyLinkedList<E> {

    private int size = 0;

    /**
     * In order to avoid some special cases when operating near the boundaries of a doubly linked list,
     * it helps to add special nodes at both ends of the list: a header node at the beginning of the list, and a trailer node at the end of the list.
     * These “dummy” nodes are known as sentinels (or guards), and they do not store elements of the primary sequence.
     */
    private DListNode<E> header;
    private DListNode<E> trailer;

    public DoublyLinkedList() {
        header = new DListNode<E>(null, null, null);
        trailer = new DListNode<E>(null, header, null);
        header.next = trailer;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param e - item to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.next);
    }


    /**
     * Adds a new element to the end of the list.
     *
     * @param e - item to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.pre, trailer);
    }

    private void addBetween(E e, DListNode<E> pre, DListNode<E> next) {
        DListNode<E> node = new DListNode<E>(e, pre, next);
        if (pre != null) {
            pre.next = node;
        }
        if (next != null) {
            next.pre = node;
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
            return remove(header.next);
        }

    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return - Removes and returns the last element of the list.
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            return remove(trailer.pre);
        }

    }

    private E remove(DListNode<E> e) {
        if (e != null) {
            DListNode<E> pre = e.pre;
            DListNode<E> next = e.next;
            if (pre != null) {
                pre.next = next;
            }
            if (next != null) {
                next.pre = pre;
            }

            size--;
            return e.item;
        }
        return null;
    }

    /**
     * Returns (but does not remove) the last element in the list.
     *
     * @return - Returns (but does not remove) the last element in the list.
     */
    public E last() {
        return isEmpty() ? null : trailer.pre.item;

    }

    /**
     * Returns (but does not remove) the first element in the list.
     *
     * @return - Returns (but does not remove) the first element in the list.
     */
    public E first() {
        return isEmpty() ? null : header.next.item;
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

    private static class DListNode<E> {

        private E item;

        private DListNode<E> pre;
        private DListNode<E> next;


        public DListNode(E item, DListNode<E> pre, DListNode<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}

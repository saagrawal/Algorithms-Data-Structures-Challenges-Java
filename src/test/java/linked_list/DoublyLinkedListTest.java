package linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void testAddingAtBeginning() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();

        /*C B D A*/
        list.addFirst("A");
        list.addFirst("D");
        list.addFirst("B");
        list.addFirst("C");

        assertEquals(4, list.size());
        assertEquals("C", list.first());
        assertEquals("A", list.last());

        assertEquals("C", list.removeFirst());
        assertEquals("B", list.first());
        assertEquals("A", list.last());
        assertEquals(3, list.size());

        assertEquals("B", list.removeFirst());
        assertEquals("D", list.first());
        assertEquals("A", list.last());
        assertEquals(2, list.size());

        assertEquals("D", list.removeFirst());
        assertEquals("A", list.removeFirst());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        assertNull(list.removeFirst());
        assertNull(list.last());
        assertNull(list.first());
    }

    @Test
    public void testAddingAtEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();

        list.addLast("A");
        list.addLast("D");
        list.addLast("B");
        list.addLast("C");

        assertEquals(4, list.size());
        assertEquals("A", list.first());
        assertEquals("C", list.last());

        assertEquals("A", list.removeFirst());
        assertEquals("D", list.first());
        assertEquals("C", list.last());
        assertEquals(3, list.size());

        assertEquals("D", list.removeFirst());
        assertEquals("B", list.first());
        assertEquals("C", list.last());
        assertEquals(2, list.size());

        assertEquals("B", list.removeFirst());
        assertEquals("C", list.removeFirst());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        assertNull(list.removeFirst());
        assertNull(list.last());
        assertNull(list.first());
    }

    @Test
    public void testAddingAtBeginingAndEnd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        /* B D A C*/
        list.addLast("A");
        list.addFirst("D");
        list.addFirst("B");
        list.addLast("C");

        assertEquals(4, list.size());
        assertEquals("B", list.first());
        assertEquals("C", list.last());

        assertEquals("B", list.removeFirst());
        assertEquals("D", list.first());
        assertEquals("C", list.last());
        assertEquals(3, list.size());

        assertEquals("D", list.removeFirst());
        assertEquals("A", list.first());
        assertEquals("C", list.last());
        assertEquals(2, list.size());

        assertEquals("A", list.removeFirst());
        assertEquals("C", list.removeFirst());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        assertNull(list.removeFirst());
        assertNull(list.last());
        assertNull(list.first());
    }

}
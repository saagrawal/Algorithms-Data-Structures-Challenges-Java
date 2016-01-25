package linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {

    @Test
    public void testRoate() {
        CircularLinkedList<String> list = new CircularLinkedList<String>();

        /* C -> A -> D-> B*/
        list.addFirst("A");
        list.addLast("D");
        list.addLast("B");
        list.addFirst("C");


        assertEquals(4, list.size());
        assertEquals("C", list.first());
        assertEquals("B", list.last());

         /* B-> D->A -> C */
        list.rotate();
        assertEquals("A", list.first());
        assertEquals("C", list.last());

    }


    @Test
    public void testAddingAtBeginning() {
        CircularLinkedList<String> list = new CircularLinkedList<String>();

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
        CircularLinkedList<String> list = new CircularLinkedList<String>();

        /*A D B C*/
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
    public void testAddingAndBeginningAtEnd() {
        CircularLinkedList<String> list = new CircularLinkedList<String>();
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
package logbook;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void test() {
        setUp();
        testAdd();
        setUp();
        testAddIndex();
        setUp();
        testAddIndexNullException();
        setUp();
        testAddNullException();
        setUp();
        testClear();
        setUp();
        testContains();
        setUp();
        testGetException();
        setUp();
        testIsEmpty();
        setUp();
        testIterator();
        setUp();
        testRemoveException();
        setUp();
        testRemoveFromEmpty();
        setUp();
        testRemoveIndex();
        setUp();
        testRemoveObj();
        setUp();
        testToArray();
    }
    
    /**
     * the list we will use
     */
    private LinkedList<String> list;

    /**
     * run before every test case
     */
    public void setUp() {
        list = new LinkedList<String>();
    }

    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }

    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        list.remove(1);
        assertEquals(1, list.getSize());
        list.add("B");
        list.remove(0);
        assertEquals(1, list.getSize());
    }

    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.getSize());
        list.add("A");
        assertEquals(1, list.getSize());
        list.add("B");
        assertEquals(2, list.getSize());
        assertEquals("B", list.get(1));

    }

    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add("A", 0);
        assertEquals("A", list.get(0));
        assertEquals(2, list.getSize());
        list.add("D", 2);
        assertEquals("D", list.get(2));
        list.add("C", 2);
        assertEquals("C", list.get(2));
    }

    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(null, 0);
        } 
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }

    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        list.add("A");
        list.add("B");
        list.remove(0);
        assertEquals( "B", list.get(0));
        assertEquals( 1, list.getSize());
        list.add("C");
        list.remove(1);
        assertEquals("B", list.get(0));
    }

    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        } 
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        } 
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse( list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }

    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue( list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }

    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.getSize());
        assertFalse(
                list.contains("A"));
    }

    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add("safety", 0);
        list.clear();
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        } 
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(  exception instanceof IndexOutOfBoundsException);
        LinkedList<String> emptyList = new LinkedList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        } 
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue( exception instanceof IndexOutOfBoundsException);
    }
    
    /**
     * Test for the clone method in LinkedList
     */
    public void testClone()
    {
    	LinkedList<String> a = new LinkedList<String>();
    	a.add("Alex");
    	a.add("Bobby");
    	a.add("Michael");
    	a.add("Miranda");
    	LinkedList<String> b = a.clone();
    	assertEquals(a.get(0), b.get(0));
    	assertEquals(a.get(1), b.get(1));
    	assertEquals(a.get(2), b.get(2));
    	assertEquals(a.get(3), b.get(3));
    }
    
    /**
     * Test for the inner class Iterator.  
     */
    public void testIterator()
    {
        LinkedList<String> people = new LinkedList<String>();
        people.add("Miranda");
        people.add("Mikalah");
        people.add("Noah");
        people.add("Bobby");
        people.add("Alex");
        Iterator<String> iter = people.iterator();
        assertTrue(iter.hasNext());
        assertEquals("Miranda", iter.next());

        assertEquals("Mikalah", iter.next());
        assertEquals("Noah", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("Bobby", iter.next());
        assertEquals("Alex", iter.next());
        assertFalse(iter.hasNext());
    }

    
    public void testToArray()
    {
    	LinkedList<String> people = new LinkedList<String>();
        people.add("Miranda");
        people.add("Mikalah");
        people.add("Noah");
        people.add("Bobby");
        people.add("Alex");
        Object[] arr = people.toArray();
        assertEquals("Miranda", arr[0]);
        
        for (int i = 0; i < arr.length; i++)
        {
        	System.out.println(arr[i]);
        }
    }
}

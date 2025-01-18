import org.junit.Test;
import softuni.Exercises.IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class IteratorTests
{
    // ------------------------------------------------------------------------------------------
    // Constructor Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfPassedElementIsNull() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testValidConstructor() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe", "Jane Doe");
    }

    // ------------------------------------------------------------------------------------------
    // Move Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void testMoveWhenThereIsANextElement() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe", "Jane Doe");
        assertTrue(listIterator.move());
    }

    @Test
    public void testMoveWhenThereIsNoNextElement() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe");
        assertFalse(listIterator.move());
    }

    @Test
    public void testMoveWhenTheListIsEmpty() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator();
        assertFalse(listIterator.move());
    }

    // ------------------------------------------------------------------------------------------
    // hasNext Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void testHasNextWhenThereIsANextElement() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe", "Jane Doe");
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextWhenThereIsNoNextElement() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe");
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextWhenTheListIsEmpty() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator();
        assertFalse(listIterator.hasNext());
    }

    // ------------------------------------------------------------------------------------------
    // Print Method Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionWhenPrintingAnEmptyList() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintWithAValidList() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe");
        assertEquals("John Doe", listIterator.print());
    }

    @Test
    public void testMoveAndPrint() throws OperationNotSupportedException
    {
        ListIterator listIterator = new ListIterator("John Doe", "Jane Doe");

        listIterator.move();

        assertEquals("Jane Doe", listIterator.print());
    }
}

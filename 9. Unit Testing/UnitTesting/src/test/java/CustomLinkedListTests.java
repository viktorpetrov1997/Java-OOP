import org.junit.Before;
import org.junit.Test;
import softuni.Exercises.CustomLinkedList;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CustomLinkedListTests
{
    private CustomLinkedList<Integer> list;

    @Before
    public void setUpCustomLinkedList()
    {
        list = new CustomLinkedList<>();
    }

    // ------------------------------------------------------------------------------------------
    // Add Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void addMethodShouldIncreaseSize()
    {
        list.add(1);
        list.add(2);

        assertEquals("List size should be 2 after adding two elements.", 2, list.indexOf(2) + 1);
    }

    @Test
    public void addMethodShouldSetElementsCorrectly()
    {
        list.add(1);
        list.add(2);

        assertEquals("First element should be 1.", Integer.valueOf(1), list.get(0));
        assertEquals("Second element should be 2.", Integer.valueOf(2), list.get(1));
    }

    // ------------------------------------------------------------------------------------------
    // Get Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void getMethodShouldReturnCorrectElement()
    {
        list.add(10);
        list.add(20);

        assertEquals("Element at index 0 should be 10.", Integer.valueOf(10), list.get(0));
        assertEquals("Element at index 1 should be 20.", Integer.valueOf(20), list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMethodShouldThrowExceptionForInvalidIndex()
    {
        list.add(1);
        list.get(1);
    }

    // ------------------------------------------------------------------------------------------
    // Set Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void setMethodShouldReplaceElement()
    {
        list.add(1);
        list.add(2);
        list.set(1, 42);

        assertEquals("Element at index 1 should be replaced with 42.", Integer.valueOf(42), list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMethodShouldThrowExceptionForInvalidIndex()
    {
        list.add(1);
        list.set(2, 42);
    }

    // ------------------------------------------------------------------------------------------
    // removeAt Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void removeAtMethodAtShouldRemoveElementAndReturnIt()
    {
        list.add(1);
        list.add(2);

        int removed = list.removeAt(0);

        assertEquals("Removed element should be 1.", 1, removed);
        assertEquals("List size should be reduced to 1 after removal.", 1, list.indexOf(2) + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowExceptionForInvalidIndex()
    {
        list.add(1);
        list.removeAt(1);
    }

    // ------------------------------------------------------------------------------------------
    // Remove Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void removeMethodShouldRemoveFirstOccurrenceOfElement()
    {
        list.add(1);
        list.add(2);
        list.add(3);

        int index = list.remove(2);

        assertEquals("Index of removed element should be 1.", 1, index);
        assertEquals("List size should be reduced to 2.", 2, list.indexOf(3) + 1);
        assertEquals("Element 2 should no longer exist in the list.", -1, list.indexOf(2));
    }

    @Test
    public void removeMethodShouldReturnMinusOneIfNotFound()
    {
        list.add(1);

        int index = list.remove(42);

        assertEquals("Remove should return -1 if element is not found.", -1, index);
    }

    // ------------------------------------------------------------------------------------------
    // indexOf Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void indexOfMethodShouldReturnCorrectIndex()
    {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals("Index of element 10 should be 0.", 0, list.indexOf(10));
        assertEquals("Index of element 20 should be 1.", 1, list.indexOf(20));
        assertEquals("Index of element 30 should be 2.", 2, list.indexOf(30));
    }

    @Test
    public void indexOfMethodShouldReturnMinusOneIfElementNotFound()
    {
        list.add(1);

        assertEquals("Index of non-existent element should be -1.", -1, list.indexOf(42));
    }

    // ------------------------------------------------------------------------------------------
    // Contains Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void containsMethodShouldReturnTrueIfElementExists()
    {
        list.add(1);
        list.add(2);

        assertTrue("List should contain 1.", list.contains(1));
        assertTrue("List should contain 2.", list.contains(2));
    }

    @Test
    public void containsMethodShouldReturnFalseIfElementIsNotFound()
    {
        list.add(1);
        assertFalse("List should not contain 42.", list.contains(42));
    }

    // ------------------------------------------------------------------------------------------
    // removeListNode Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void removeListNodeMethodUpdatesHeadTailAndCount()
    {
        list.add(1);
        list.add(2);
        list.add(3);

        // Remove the head element
        list.removeAt(0);
        assertEquals("Head should now point to the second element.", Integer.valueOf(2), list.get(0));
        assertEquals("List size should be reduced to 2.", 2, list.indexOf(3) + 1);

        // Remove the tail element
        list.removeAt(1);
        assertEquals("Tail should now point to the second element.", Integer.valueOf(2), list.get(0));
        assertEquals("List size should be reduced to 1.", 1, list.indexOf(2) + 1);

        // Remove the last element, list becomes empty
        list.removeAt(0);
        assertEquals("List should be empty after removing all elements.", -1, list.indexOf(2));
    }

    // ------------------------------------------------------------------------------------------
    // getCount Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void testGetCountUsingReflection() throws Exception
    {
        // Access the private getCount method using reflection
        Method getCountMethod = CustomLinkedList.class.getDeclaredMethod("getCount");
        getCountMethod.setAccessible(true); // Make the method accessible

        // Initially, the count should be 0
        int count = (int) getCountMethod.invoke(list);
        assertEquals("Initial count should be 0.", 0, count);

        // Add elements to the list
        list.add(1);
        list.add(2);
        list.add(3);

        // Check count after additions
        count = (int) getCountMethod.invoke(list);
        assertEquals("Count should be 3 after adding three elements.", 3, count);

        // Remove an element
        list.removeAt(1);

        // Check count after removal
        count = (int) getCountMethod.invoke(list);
        assertEquals("Count should be 2 after removing one element.", 2, count);
    }
}

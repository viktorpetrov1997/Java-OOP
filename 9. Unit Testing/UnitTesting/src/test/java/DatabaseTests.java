import org.junit.Test;
import softuni.Exercises.Database;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertArrayEquals;

public class DatabaseTests
{
    // ------------------------------------------------------------------------------------------
    // Constructor Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenArraySizeExceeds16() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenArraySizeIsZero() throws OperationNotSupportedException
    {
        Database database = new Database();
    }

    @Test
    public void shouldWorkWhenArraySizeIsWithinLimits() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5);
        Integer[] elements = database.getElements();

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNonIntegerValuesAreProvidedInConstructor() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException
    {
        Constructor<Database> constructor = Database.class.getDeclaredConstructor(Integer[].class);

        constructor.setAccessible(true);
        constructor.newInstance((Object) new Object[]{1, 2, "String"});
    }

    // ------------------------------------------------------------------------------------------
    // Add Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void shouldAddElementAtTheNextFreeCell() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5);

        database.add(6);

        Integer[] elements = database.getElements();
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddedElementIsNull() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5);

        database.add(null);
    }

    // ------------------------------------------------------------------------------------------
    // Remove Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void removeMethodShouldRemoveTheLastElement() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5);

        database.remove();

        Integer[] elements = database.getElements();
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenTryingToRemoveFromAnEmptyDatabase() throws OperationNotSupportedException
    {
        Database database = new Database();

        database.remove();
    }

    // ------------------------------------------------------------------------------------------
    // Get Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void fetchShouldReturnAllElementsAsArray() throws OperationNotSupportedException
    {
        Database database = new Database(1, 2, 3, 4, 5);

        Integer[] fetchedElements = database.getElements();

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, fetchedElements);
    }
}

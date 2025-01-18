import org.junit.Test;
import softuni.Exercises.ExtendedDatabase.Database;
import softuni.Exercises.ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ExtendedDatabaseTests
{
    // ------------------------------------------------------------------------------------------
    // Constructor Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void testValidConstructor() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(2, "Jane Doe");
        Database database = new Database(person1, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenNumberOfPeopleExceeds16() throws OperationNotSupportedException
    {
        Person[] people = new Person[17];
        for(int i = 0; i < 17; i++)
        {
            people[i] = new Person(i, "Person" + i);
        }

        Database database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenConstructorIsEmpty() throws OperationNotSupportedException
    {
        Database database = new Database();
    }

    // ------------------------------------------------------------------------------------------
    // Add Method Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenThereAreMultipleUsersWithSameId() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(1, "Jane Doe");

        Database database = new Database(person1);

        database.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenIdIsNegative() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(-2, "Jane Doe");

        Database database = new Database(person1);

        database.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenIdIsNull() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(null, "Jane Doe");

        Database database = new Database(person1);

        database.add(person2);
    }

    @Test
    public void addValidPerson() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(2, "Jane Doe");

        Database database = new Database(person1);
        database.add(person2);

        Person[] elements = database.getElements();
        assertEquals(2, elements.length);
        assertEquals("Jane Doe", elements[1].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddedPersonIsNull() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");

        Database database = new Database(person1);

        database.add(null);
    }

    // ------------------------------------------------------------------------------------------
    // findByUsername Method Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfNoSuchUserExists() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.findByUsername("NonExistentUser");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfUsernameIsNull() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.findByUsername(null);
    }

    @Test
    public void testValidFindByUsername() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.findByUsername("John Doe");
    }

    // ------------------------------------------------------------------------------------------
    // findById Method Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfNoSuchUserWithGivenIdExists() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.findById(2);
    }

    @Test
    public void testValidFindById() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.findById(1);
    }

    // ------------------------------------------------------------------------------------------
    // Remove Method Tests
    // ------------------------------------------------------------------------------------------

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenTryingToRemoveFromAnEmptyDatabase() throws OperationNotSupportedException
    {
        Person person = new Person(1, "John Doe");
        Database database = new Database(person);

        database.remove();
        database.remove();
    }

    @Test
    public void testValidRemoval() throws OperationNotSupportedException
    {
        Person person1 = new Person(1, "John Doe");
        Person person2 = new Person(2, "Jane Doe");

        Database database = new Database(person1, person2);

        database.remove();

        Person[] elementsAfterRemoval = database.getElements();
        assertEquals(1, elementsAfterRemoval.length);
    }
}

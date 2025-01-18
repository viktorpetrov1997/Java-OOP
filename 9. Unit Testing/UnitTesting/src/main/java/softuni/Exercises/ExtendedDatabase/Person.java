package softuni.Exercises.ExtendedDatabase;

public class Person
{
    private Integer id;
    private String name;

    public Person(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId()
    {
        return this.id;
    }

    public String getUsername()
    {
        return this.name;
    }
}

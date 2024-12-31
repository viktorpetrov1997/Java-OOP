package Encapsulation.Lab.ValidationData;

public class Person
{
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setFirstName(String firstName)
    {
        if(firstName.length() < 3)
        {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setLastName(String lastName)
    {
        if(lastName.length() < 3)
        {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setAge(int age)
    {
        if(age <= 0)
        {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setSalary(double salary)
    {
        if(salary < 460.0)
        {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public double getSalary()
    {
        return this.salary;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s gets %.2f leva", this.getFirstName(), this.getLastName(), this.getSalary());
    }

    public void increaseSalary(double percentageIncrease)
    {
        if(this.getAge() < 30)
        {
            this.setSalary(this.getSalary() + (this.getSalary() * percentageIncrease / 200));
        }
        else
        {
            this.setSalary(this.getSalary() + (this.getSalary() * percentageIncrease / 100));
        }
    }
}

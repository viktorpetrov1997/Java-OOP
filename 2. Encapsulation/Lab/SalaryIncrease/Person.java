package Encapsulation.Lab.SalaryIncrease;

public class Person
{
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public int getAge()
    {
        return this.age;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
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

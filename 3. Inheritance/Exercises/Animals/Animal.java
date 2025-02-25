package Inheritance.Exercises.Animals;

public class Animal
{
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender)
    {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        if(age < 0)
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setGender(String gender)
    {
        if(gender == null || gender.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

    public String produceSound()
    {
        return "";
    }

    @Override
    public String toString()
    {
        StringBuilder animalInfo = new StringBuilder();

        animalInfo.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(String.format("%s %d %s", name, age, gender))
                .append(System.lineSeparator())
                .append(produceSound());

        return animalInfo.toString().trim();
    }
}

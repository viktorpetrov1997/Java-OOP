package InterfacesAndAbstraction.Lab.SayHelloExtended;

abstract class BasePerson implements Person
{
    private String name;

    protected BasePerson(String name)
    {
        setName(name);
    }

    @Override
    public String getName()
    {
        return name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    @Override
    public abstract String sayHello();
}

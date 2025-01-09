package Polymorphism.Exercises.Word;

public class Initialization
{
    public static CommandInterface buildCommandInterface(StringBuilder text)
    {
        CommandImpl commandImpl = new CommandImpl(text);
        commandImpl.init();
        return commandImpl;
    }
}

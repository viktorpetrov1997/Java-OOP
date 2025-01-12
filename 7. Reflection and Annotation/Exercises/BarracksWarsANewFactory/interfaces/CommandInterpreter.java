package Reflection.Exercises.BarracksWarsANewFactory.interfaces;

public interface CommandInterpreter
{
	Executable interpretCommand(String[] data, String commandName);
}

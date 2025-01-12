package Reflection.Exercises.BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException
    {
        Scanner scanner = new Scanner(System.in);

        Class<?> blackBoxIntClass = BlackBoxInt.class;

        Constructor<?> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object blackBoxIntInstance = constructor.newInstance();

        Field innerValueField = blackBoxIntClass.getDeclaredField("innerValue");
        innerValueField.setAccessible(true);

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] commandParts = input.split("_");

            String command = commandParts[0];
            int value = Integer.parseInt(commandParts[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxIntInstance, value);

            int currentValue = (int) innerValueField.get(blackBoxIntInstance);
            System.out.println(currentValue);

            input = scanner.nextLine();
        }
    }
}

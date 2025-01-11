package Reflection.Lab.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        Field[] fields = Reflection.class.getDeclaredFields();

        System.out.println("Fields:");

        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = Reflection.class.getDeclaredMethods();

        System.out.println("\nMethods:");

        Arrays.stream(methods).sorted((Comparator.comparing(Method::getName)))
                .forEach(method ->
                {
                    if(method.getName().startsWith("get"))
                    {
                        if(!Modifier.isPublic(method.getModifiers()))
                        {
                            System.out.println(method.getName() + " have to be public!");
                        }
                    }
                    else if(method.getName().startsWith("set"))
                    {
                        if(!Modifier.isPrivate(method.getModifiers()))
                        {
                            System.out.println(method.getName() + " have to be private!");
                        }
                    }
                });
    }
}

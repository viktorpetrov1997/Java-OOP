package Reflection.Lab.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            // Load the Reflection class dynamically
            Class<?> clazz = Class.forName("Reflection.Lab.Reflection.Reflection");

            // Print class type
            System.out.println("Class Type: " + clazz.getName());

            System.out.println();

            // Print super class type
            Class<?> superClass = clazz.getSuperclass();
            System.out.println("Super Class Type: " + (superClass != null ? superClass.getName() : "None"));

            System.out.println();

            // Print all implemented interfaces
            Class<?>[] interfaces = clazz.getInterfaces();
            System.out.println("Implemented Interfaces:");
            for(Class<?> i : interfaces)
            {
                System.out.println("- " + i.getName());
            }

            System.out.println();

            // Instantiate an object of Reflection class using the no-arg constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // In case the constructor is private
            Object instance = constructor.newInstance();
            System.out.println("Instantiated Object: \n" + instance);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class not found: " + e.getMessage());
        }
        catch(NoSuchMethodException e)
        {
            System.out.println("No such method: " + e.getMessage());
        }
        catch(IllegalAccessException e)
        {
            System.out.println("Illegal access: " + e.getMessage());
        }
        catch(InstantiationException e)
        {
            System.out.println("Instantiation failed: " + e.getMessage());
        }
        catch(InvocationTargetException e)
        {
            System.out.println("Invocation target exception: " + e.getCause());
        }
    }
}

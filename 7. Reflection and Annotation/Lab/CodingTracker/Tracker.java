package Reflection.Lab.CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker
{
    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz)
    {
        Method[] methods = clazz.getDeclaredMethods();

        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        for(Method method : methods)
        {
            Author author = method.getAnnotation(Author.class);
            if(author != null)
            {
                methodsByAuthor.putIfAbsent(author.name(), new ArrayList<>());
                methodsByAuthor.get(author.name()).add(method.getName());
            }
        }

        for(Map.Entry<String, List<String>> entry : methodsByAuthor.entrySet())
        {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }

    @Author(name = "George")
    public static void main(String[] args)
    {
        printMethodsByAuthor(Tracker.class);
    }
}

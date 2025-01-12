package Reflection.Exercises.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        String command = scanner.nextLine();
        while(!command.equals("HARVEST"))
        {
            for(Field field : fields)
            {
                int modifier = field.getModifiers();

                String modifierName = "";

                if(Modifier.isPrivate(modifier))
                {
                    modifierName = "private";
                }
                else if(Modifier.isProtected(modifier))
                {
                    modifierName = "protected";
                }
                else if(Modifier.isPublic(modifier))
                {
                    modifierName = "public";
                }

                if(command.equals("all") || command.equals(modifierName))
                {
                    System.out.printf("%s %s %s%n", modifierName, field.getType().getSimpleName(), field.getName());
                }
            }
            command = scanner.nextLine();
        }
    }
}

package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String input = scanner.nextLine();
        while(!input.equals("Exit"))
        {
            String[] studentInfo = input.split(" ");

            String command = studentInfo[0];
            if(command.equals("Create"))
            {
                String name = studentInfo[1];
                int age = Integer.parseInt(studentInfo[2]);
                double grade = Double.parseDouble(studentInfo[3]);

                Student student = new Student(name, age, grade);
                studentSystem.addStudent(student);
            }
            else if(command.equals("Show"))
            {
                String name = studentInfo[1];
                studentSystem.printStudentInfo(name);
            }

            input = scanner.nextLine();
        }
    }
}

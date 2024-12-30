package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.HashMap;

public class StudentSystem
{
    private HashMap<String, Student> students;

    public StudentSystem()
    {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student)
    {
        if(!this.students.containsKey(student.getName()))
        {
            this.students.put(student.getName(), student);
        }
    }

    public Student getStudent(String studentName)
    {
        return this.students.get(studentName);
    }

    public void printStudentInfo(String studentName)
    {
        Student student = this.getStudent(studentName);

        if(student != null)
        {
            String studentInfo = String.format("%s is %d years old. %s",
                    student.getName(), student.getAge(), student.getCommentary());

            System.out.println(studentInfo);
        }
    }
}

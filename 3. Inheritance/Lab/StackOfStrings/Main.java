package Inheritance.Lab.StackOfStrings;

public class Main // This task must be submitted with a package called 'StackOfStrings'.
{
    public static void main(String[] args)
    {
        StackOfStrings sos = new StackOfStrings();

        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());

        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}

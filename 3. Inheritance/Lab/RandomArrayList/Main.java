package Inheritance.Lab.RandomArrayList;

public class Main // This task must be submitted with a package called 'RandomArrayList'.
{
    public static void main(String[] args)
    {
        RandomArrayList<String> randomArrayList = new RandomArrayList<>();

        randomArrayList.add("Element 1");
        randomArrayList.add("Element 2");
        randomArrayList.add("Element 3");
        randomArrayList.add("Element 4");
        randomArrayList.add("Element 5");
        randomArrayList.add("Element 6");
        randomArrayList.add("Element 7");
        randomArrayList.add("Element 8");
        randomArrayList.add("Element 9");
        randomArrayList.add("Element 10");

        System.out.println(randomArrayList.getRandomElement());
    }
}

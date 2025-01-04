package Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T>
{
    private Random random;

    public RandomArrayList()
    {
        super();
        this.random = new Random();
    }

    public Object getRandomElement()
    {
        int index = this.random.nextInt(super.size());
        T element = super.get(index);
        super.remove(index);
        return element;
    }
}

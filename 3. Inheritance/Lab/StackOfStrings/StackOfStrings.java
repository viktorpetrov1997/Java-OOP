package Inheritance.Lab.StackOfStrings;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings
{
    private ArrayList<String> data;

    public StackOfStrings()
    {
        this.data = new ArrayList<>();
    }

    public void push(String item)
    {
        data.add(item);
    }

    public String pop()
    {
        if(data.isEmpty())
        {
            throw new NoSuchElementException("StackOfStrings is empty.");
        }

        int index = data.size() - 1;

        return data.remove(index);
    }

    public String peek()
    {
        if(data.isEmpty())
        {
            throw new NoSuchElementException("StackOfStrings is empty.");
        }

        int index = data.size() - 1;

        return data.get(index);
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }
}

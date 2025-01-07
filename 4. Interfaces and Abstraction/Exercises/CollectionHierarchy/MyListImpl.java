package InterfacesAndAbstraction.Exercises.CollectionHierarchy;

public class MyListImpl extends Collection implements MyList
{
    @Override
    public int add(String item)
    {
        if(items.size() < maxSize)
        {
            items.add(0, item);
        }
        return 0;
    }

    @Override
    public String remove()
    {
        if(items.isEmpty())
        {
            return "";
        }
        return items.remove(0);
    }

    @Override
    public int getUsed()
    {
        return items.size();
    }
}

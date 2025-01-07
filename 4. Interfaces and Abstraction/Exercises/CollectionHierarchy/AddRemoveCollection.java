package InterfacesAndAbstraction.Exercises.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable
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
        return items.remove(items.size() - 1);
    }
}
